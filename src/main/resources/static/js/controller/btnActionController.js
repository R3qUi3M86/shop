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
    }
}

async function selectCategoryEvtHandler(e){
    const target = e.currentTarget;
    const products = await dataHandler.getProductsByCategory(target.dataset.categoryId);
    domManager.deactivateAllCategories();
    target.classList.add("active");
    domManager.clearProductsContainer();
    domManager.displayProducts(products);
}

async function addProductToCartEvtHandler(e){
    const target = e.currentTarget;
    const prodId = target.dataset.productId;
    const response = await dataHandler.addProductToCart({"userName": "stiepan", "productId": prodId});
    const cartQty = document.getElementById("cart-item-qty");
    cartQty.innerText = response["productsCount"];
    cartQty.classList.remove("visually-hidden")
}