import {cardTypes} from "../model/builders/cardBuilder.js";
import {htmlFactory, htmlTemplates} from "../model/htmlFactory.js";

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
        const cardBuilder = htmlFactory(htmlTemplates.card);
        productsArray.forEach((e) => {
            domManager.addChild("products", cardBuilder(cardTypes.productCard, e));
        })
    }
}