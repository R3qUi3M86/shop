import  {domManager} from "../../view/domManager.js";
import {buttonBuilder} from "./buttonBuilder.js";
import {buttonTypes} from "./buttonBuilder.js";

export const cardTypes = {
    productCard: "product card"
}

export function cardBuilder(type, product){
    switch (type){
        case cardTypes.productCard:
            return buildProductCardContainer(product);
    }

function buildProductCardContainer(product) {
    const productCardContainer = document.createElement("div");
    productCardContainer.classList.add("col", "col-sm-12", "col-md-6", "col-lg-4", "mb-1");

    const productCard = document.createElement("div");
    productCard.classList.add("card");
    productCard.setAttribute("style", "height:100%");

    const productImg = document.createElement("img");
    productImg.setAttribute("class", "");
    productImg.src = 'img/product_' + product.id + '.jpg';
    productImg.setAttribute("alt", "")

    const cardHeader = document.createElement("div");
    cardHeader.classList.add("card-header");
    cardHeader.setAttribute("style", "height:100%");

    const productTitle = document.createElement("h4");
    productTitle.classList.add("card-title");
    productTitle.innerText = product.name;

    const productDesc = document.createElement("p");
    productDesc.classList.add("card-text");
    productDesc.innerText = product.description;

    const cardBody = document.createElement("div");
    cardBody.classList.add("card-body");

    const cardTextPrice = document.createElement("div");
    cardTextPrice.classList.add("card-text");

    const productPrice = document.createElement("p");
    productPrice.classList.add("lead");
    productPrice.innerText = product.defaultPrice + " " + product.defaultCurrency;

    const cardTextBtn = document.createElement("div");
    cardTextBtn.classList.add("card-text");

    const addToCart = buttonBuilder(buttonTypes.productBtn, product.id);

    productCardContainer.appendChild(productCard);
    productCard.appendChild(productImg);
    productCard.appendChild(cardHeader)
    productCard.appendChild(cardBody)
    cardHeader.appendChild(productTitle);
    cardHeader.appendChild(productDesc);
    cardBody.appendChild(cardTextPrice);
    cardBody.appendChild(cardTextBtn);
    cardTextPrice.appendChild(productPrice);
    cardTextBtn.appendChild(addToCart);

    return productCardContainer;
}
}