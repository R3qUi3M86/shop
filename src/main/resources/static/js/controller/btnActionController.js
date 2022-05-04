import {dataHandler} from "../model/dataHandler.js";
import {domManager} from "../view/domManager.js";
import {htmlFactory, htmlTemplates} from "../model/htmlFactory.js";
import {basketTypes} from "../model/builders/basketBuilder.js";


export const btnActionController = {
    setCategoryButtonsEvtHandlers() {
        const categoryBtnsParent = document.getElementById("categoryListContainer");
        const categoryElemArray = Array.from(categoryBtnsParent.children);
        categoryElemArray.forEach((e) => {
            e.addEventListener("click", selectCategoryEvtHandler);
        })
    },

    setSupplierButtonsEvtHandlers() {
        const supplierBtnsParent = document.getElementById("supplierListContainer");
        const supplierElemArray = Array.from(supplierBtnsParent.children);
        supplierElemArray.forEach((e) => {
            e.addEventListener("click", selectSupplierEvtHandler);
        })
    },

    setProductBuyEvtHandlers() {
        const buyButtons = Array.from(document.querySelectorAll(".buy-btn"));
        buyButtons.forEach(btn => btn.addEventListener("click", addProductToCartEvtHandler));
    },

    setCartShowEvtHandler(){
        const showCartBtn = document.getElementById("showCartBtn");
        showCartBtn.addEventListener("click", updateCartContentEvtHandler);
    },

    setEmptyCartEvtHandler(){
        const emptyCartBtn = document.getElementById("emptyCartBtn");
        emptyCartBtn.addEventListener("click", emptyCartEvtHandler);
    },

    setCheckoutEvtHandler(){
        const checkoutBtn = document.getElementById("checkoutBtn");
        checkoutBtn.addEventListener("click", checkoutEvtHandler);
    },

    setAddRemoveProductEvtHandlers(){
        const decreaseProductAmtBtns = Array.from(document.querySelectorAll("#removeProductBtn"));
        const increaseProductAmtBtns = Array.from(document.querySelectorAll("#addProductBtn"));
        for (let btn of decreaseProductAmtBtns){
            btn.addEventListener("click", decreaseProductAmtEvtHandler)
        }
        for (let btn of increaseProductAmtBtns){
            btn.addEventListener("click", increaseProductAmtEvtHandler)
        }
    }
}

async function selectSupplierEvtHandler(e) {
    const target = e.currentTarget;
    let products;
    products = await dataHandler.getProductsByCustomFilter(target.dataset.supplierId, domManager.getActiveCategoryButton().dataset.categoryId)
    domManager.deactivateAllSuppliers();
    target.classList.add("active");
    domManager.clearProductsContainer();
    domManager.displayProducts(products);

    btnActionController.setSupplierButtonsEvtHandlers();
    btnActionController.setProductBuyEvtHandlers();
}

async function selectCategoryEvtHandler(e) {
    const target = e.currentTarget;
    let products;
    products = await dataHandler.getProductsByCustomFilter(domManager.getActiveSupplierButton().dataset.supplierId, target.dataset.categoryId)
    domManager.deactivateAllCategories();
    target.classList.add("active");
    domManager.clearProductsContainer();
    domManager.displayProducts(products);

    btnActionController.setSupplierButtonsEvtHandlers();
    btnActionController.setProductBuyEvtHandlers();

}

async function addProductToCartEvtHandler(e) {
    const target = e.currentTarget;
    const prodId = target.dataset.productId;
    const response = await dataHandler.addProductToCart({"userName": "stiepan", "productId": prodId});
    domManager.updateCartIconQuantity(response["productsCount"])
}

async function updateCartContentEvtHandler(){
    const order = await dataHandler.getUserOrder("stiepan");
    const basketBuilder = htmlFactory(htmlTemplates.basket);
    if (order["order"] === "not found" || order["products"].length === 0){
        domManager.refreshBasketContent(basketBuilder(basketTypes.basketEmpty))
        domManager.disableButton("emptyCartBtn");
        domManager.disableButton("checkoutBtn");
    } else {
        domManager.refreshBasketContent(basketBuilder(basketTypes.basketProducts, order["order"]["orderedProducts"], order["products"]))
        domManager.enableButton("emptyCartBtn");
        domManager.enableButton("checkoutBtn");
        btnActionController.setAddRemoveProductEvtHandlers();
    }
}

async function emptyCartEvtHandler(){
    const basketBuilder = htmlFactory(htmlTemplates.basket);
    domManager.refreshBasketContent(basketBuilder(basketTypes.basketEmpty))
    domManager.disableButton("emptyCartBtn");
    domManager.disableButton("checkoutBtn");
    domManager.updateCartIconQuantity(0)
    let response = await dataHandler.emptyCart("stiepan")
    console.info(response["status"]);
}

async function increaseProductAmtEvtHandler(e){
    const target = e.currentTarget;
    let response = await dataHandler.addProductToCart({"userName": "stiepan", "productId": target.dataset.productId});
    domManager.updateCartIconQuantity(response["productsCount"]);
    updateCartContentEvtHandler();
}

async function decreaseProductAmtEvtHandler(e){
    const target = e.currentTarget;
    let response = await dataHandler.removeProductFromCart({"userName": "stiepan", "productId": target.dataset.productId});
    domManager.updateCartIconQuantity(response["productsCount"]);
    updateCartContentEvtHandler();
}

async function checkoutEvtHandler(){
    let response = dataHandler.getCheckoutPage("stiepan");
}