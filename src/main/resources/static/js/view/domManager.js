import {cardBuilder} from "../model/builders/cardBuilder.js";
import {cardTypes} from "../model/builders/cardBuilder.js";

export const domManager = {
    addChild(parentId, child){
        const parent = document.getElementById(parentId);
        if (parent){
            parent.appendChild(child);
        } else {
            console.error("could not find such html element: " + parentId);
        }
    },

    deactivateAllCategories(){
        const categoryBtnsParent = document.getElementById("categoryListContainer");
        const categoryElemArray = Array.from(categoryBtnsParent.children);
        categoryElemArray.forEach((e) => {
            e.classList.remove("active");
        })
    },

    clearProductsContainer() {
        const productsContainer = document.getElementById("products");
        productsContainer.innerHTML = "";
    },

    displayProducts(products) {
        const productsArray = Array.from(products);
        productsArray.forEach((e) => {
            domManager.addChild("products", cardBuilder(cardTypes.productCard, e))
        })
    }
}