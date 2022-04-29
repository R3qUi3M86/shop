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
    if (domManager.categoryFilterIsActive()) {
        const categoryButton = domManager.getActiveCategoryButton();
        products = await dataHandler.getProductsByCustomFilter(target.dataset.supplierId, categoryButton.dataset.categoryId)
        console.log(products);
    } else {
        products = await dataHandler.getProductsBySupplier(target.dataset.supplierId);
    }
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
    if (domManager.supplierFilterIsActive()) {
        const supplierButton = domManager.getActiveSupplierButton();
        products = await dataHandler.getProductsByCustomFilter(target.dataset.categoryId, supplierButton.dataset.supplierId)
        console.log(products);
    } else {
        products = await dataHandler.getProductsByCategory(target.dataset.categoryId);
    }
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
    //TODO implement cart icon update;
}