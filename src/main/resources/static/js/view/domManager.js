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

    refreshBasketContent(content){
        const parent = document.getElementById("cartModalContent");
        parent.innerHTML = "";
        parent.appendChild(content);
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
    },
    deactivateAllSuppliers() {
        const supplierBtnsParent = document.getElementById("supplierListContainer");
        const supplierElemArray = Array.from(supplierBtnsParent.children);
        supplierElemArray.forEach((e) => {
            e.classList.remove("active");
        })
    },

    categoryFilterIsActive() {
        const categoryBtnsParent = document.getElementById("categoryListContainer");
        const categoryElemArray = Array.from(categoryBtnsParent.children);
        let result = false;
        categoryElemArray.forEach((e) => {
            if(e.classList.contains("active")){
                result = true;
            }
        })
        return result;
    },

    supplierFilterIsActive() {
        const supplierBtnsParent = document.getElementById("supplierListContainer");
        const supplierElemArray = Array.from(supplierBtnsParent.children);
        let result = false;
        supplierElemArray.forEach((e) => {
            if(e.classList.contains("active")){
                result = true;
            }
        })
        return result;
    },

    getActiveCategoryButton() {
        const categoryBtnsParent = document.getElementById("categoryListContainer");
        const categoryElemArray = Array.from(categoryBtnsParent.children);
        let result = null
        categoryElemArray.forEach((e) => {
            if(e.classList.contains("active")){
                result = e
            }
        })
        return result;
    },

    getActiveSupplierButton() {
        const supplierBtnsParent = document.getElementById("supplierListContainer");
        const supplierElemArray = Array.from(supplierBtnsParent.children);
        let result = null;
        supplierElemArray.forEach((e) => {
            if(e.classList.contains("active")){
                result = e;
            }
        })
        return result;
    },

    enableButton(buttonId){
        const button = document.getElementById(buttonId);
        if (button){
            button.classList.remove("disabled");
        } else {
            console.error("could not find such html element: " + buttonId);
        }
    },

    disableButton(buttonId){
        const button = document.getElementById(buttonId);
        if (button){
            button.classList.add("disabled");
        } else {
            console.error("could not find such html element: " + buttonId);
        }
    },

    updateCartIconQuantity(qty){
        const cartQty = document.getElementById("cart-item-qty");
        if (cartQty){
            cartQty.innerText = qty;
            if (parseInt(qty) > 0){
                cartQty.classList.remove("visually-hidden");
            } else {
                cartQty.classList.add("visually-hidden");
            }
        }
    }
}