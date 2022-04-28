import {dataHandler} from "../model/dataHandler.js";
import {domManager} from "../view/domManager.js";

export const btnActionController = {
    setCategoryButtonsEvtHandlers() {
        const categoryBtnsParent = document.getElementById("categoryListContainer");
        const categoryElemArray = Array.from(categoryBtnsParent.children);
        categoryElemArray.forEach((e) => {
            e.addEventListener("click", selectCategoryEvtHandler);
        })
    }
}

async function selectCategoryEvtHandler(e){
    const target = e.currentTarget;
    const products = await dataHandler.getProductsByCategory(target.dataset.categoryId);
    console.log(products);
    domManager.deactivateAllCategories();
    target.classList.add("active");
}