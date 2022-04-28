import  {domManager} from "../../view/domManager.js";
import {buttonBuilder} from "./buttonBuilder.js";
import {buttonTypes} from "./buttonBuilder.js";

export const cardTypes = {
    productCard: "product card"
}

export function cardBuilder(type, content){
    switch (type){
        case cardTypes.productCard:
            const productCardContainer = document.createElement("div");
            productCardContainer.classList.add("col","col-sm-12", "col-md-6", "col-lg-4");

            const productCard = document.createElement("div");
            productCard.classList.add("card");

            const productImg = document.createElement("img");
            productImg.setAttribute("class", "");
            productImg.src = 'img/product_' + content.id + '.jpg';
            productImg.setAttribute("alt", "")

            const cardHeader = document.createElement("div");
            cardHeader.classList.add("card-header");

            const productTitle = document.createElement("h4");
            productTitle.classList.add("card-title");
            productTitle.innerText = content.name;

            const productDesc = document.createElement("p");
            productDesc.classList.add("card-text");
            productDesc.innerText = content.description;

            const cardBody = document.createElement("div");
            cardBody.classList.add("card-body");

            const cardTextPrice = document.createElement("div");
            cardTextPrice.classList.add("card-text");

            const productPrice = document.createElement("p");
            productPrice.classList.add("lead");
            productPrice.innerText = content.defaultPrice + " " + content.defaultCurrency;

            const cardTextBtn = document.createElement("div");
            cardTextBtn.classList.add("card-text");

            const addToCart = buttonBuilder(buttonTypes.productBtn, content.id);

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