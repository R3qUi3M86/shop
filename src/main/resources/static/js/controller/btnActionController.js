import {dataHandler} from "../model/dataHandler.js";
import {domManager} from "../view/domManager.js";


export const btnActionController = {
    setCategoryButtonsEvtHandlers() {
        const categoryBtnsParent = document.getElementById("categoryListContainer");
        const categoryElemArray = Array.from(categoryBtnsParent.children);
        categoryElemArray.forEach((e) => {
            e.addEventListener("click", selectCategoryEvtHandler);
        })
    },

    setProductBuyEvtHandlers() {
        const buyButtons = Array.from(document.querySelectorAll(".buy-btn"));
        buyButtons.forEach(btn => btn.addEventListener("click", addProductToCartEvtHandler));
    },
    setSupplierButtonsEvtHandlers() {
        const supplierBtnsParent = document.getElementById("supplierListContainer");
        const supplierElemArray = Array.from(supplierBtnsParent.children);
        supplierElemArray.forEach((e) => {
            e.addEventListener("click", selectSupplierEvtHandler);
        })
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
    const cartQty = document.getElementById("cart-item-qty");
    cartQty.innerText = response["productsCount"];
    cartQty.classList.remove("visually-hidden")
}