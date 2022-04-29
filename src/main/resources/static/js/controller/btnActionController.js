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
    if (target.dataset.supplierId == 0) {
        if (domManager.getActiveCategoryButton().dataset.categoryId > 0) {
            products = await dataHandler.getProductsByCategory(domManager.getActiveCategoryButton().dataset.categoryId);
        } else {
            products = await dataHandler.getAllProducts();
        }
    } else {
        if (domManager.categoryFilterIsActive() && domManager.getActiveCategoryButton().dataset.categoryId > 0) {
            const categoryButton = domManager.getActiveCategoryButton();
            products = await dataHandler.getProductsByCustomFilter(target.dataset.supplierId, categoryButton.dataset.categoryId)
        } else {
            products = await dataHandler.getProductsBySupplier(target.dataset.supplierId);
        }
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
    if (target.dataset.categoryId == 0) {
        if (domManager.getActiveSupplierButton().dataset.supplierId > 0) {
            products = await dataHandler.getProductsBySupplier(domManager.getActiveSupplierButton().dataset.supplierId);
        } else {
            products = await dataHandler.getAllProducts();
        }
    } else {
        if (domManager.supplierFilterIsActive() && domManager.getActiveSupplierButton().dataset.supplierId > 0) {
            const supplierButton = domManager.getActiveSupplierButton();
            products = await dataHandler.getProductsByCustomFilter(supplierButton.dataset.supplierId, target.dataset.categoryId)
        } else {
            products = await dataHandler.getProductsByCategory(target.dataset.categoryId);
        }

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