import {buttonBuilder, buttonTypes} from "./buttonBuilder.js";

export const basketTypes = {
    basketEmpty: "empty basket",
    basketProducts: "products in basket"
}

export function basketBuilder(basketType, productsQty, products) {
    switch (basketType){
        case basketTypes.basketEmpty:
            const emptyBasketContainer = document.createElement("div");
            const emptyBasketText = document.createElement("h3");
            emptyBasketContainer.classList.add("text-center", "flex-grow-1");
            emptyBasketText.innerText = "Your cart is empty";
            emptyBasketContainer.appendChild(emptyBasketText)
            return emptyBasketContainer;

        case basketTypes.basketProducts:
            const tableContainer = document.createElement("div");
            const table = document.createElement("table");
            const thead = document.createElement("thead");
            const headerRow = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            const th4 = document.createElement("th");
            const th5 = document.createElement("th");
            table.appendChild(thead);
            thead.appendChild(headerRow);
            headerRow.appendChild(th1);
            headerRow.appendChild(th2);
            headerRow.appendChild(th3);
            headerRow.appendChild(th4);
            headerRow.appendChild(th5);

            table.classList.add("table");

            th1.innerText = "Product";
            th1.scope = "col";
            th2.innerText = "Quantity";
            th2.scope = "col";
            th2.classList.add("text-center");
            th3.innerText = "Remove|Add";
            th3.scope = "col";
            th3.classList.add("text-center");
            th4.innerText = "Unit Price";
            th4.scope = "col";
            th4.classList.add("text-center");
            th5.innerText = "Total Price";
            th5.scope = "col";
            th5.classList.add("text-end");

            const tbody = document.createElement("tbody");
            let totalPrice = 0;

            for (let product of products){
                const subTotalPrice = (parseFloat(product["defaultPrice"]) * parseInt(productsQty[parseInt(product["id"])]))
                    .toFixed(2)

                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                td2.classList.add("text-center");
                const td3 = document.createElement("td");
                td3.classList.add("text-center");
                const td4 = document.createElement("td");
                td4.classList.add("text-center");
                const td5 = document.createElement("td");
                td5.classList.add("text-end");

                td1.innerText = product["name"];
                td2.innerText = productsQty[product["id"]];
                td3.appendChild(buttonBuilder(buttonTypes.addRemoveProductBtnGroup));
                td3.firstElementChild.firstElementChild.setAttribute("data-product-id", product["id"]);
                td3.firstElementChild.lastElementChild.setAttribute("data-product-id", product["id"])

                td4.innerText = product["defaultPrice"] + " " + product["defaultCurrency"];
                td5.innerText = subTotalPrice.toString() + " " + product["defaultCurrency"];

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);
                tableRow.appendChild(td5);
                tbody.appendChild(tableRow);

                totalPrice += parseFloat(subTotalPrice);
            }
            table.appendChild(tbody);
            const thead2 = document.createElement("thead")
            table.appendChild(thead2);

            const totalPriceDiv = document.createElement("div");
            totalPriceDiv.classList.add("pe-2", "fw-bold", "d-flex", "flex-grow-1", "justify-content-end")
            totalPriceDiv.innerText = totalPrice.toFixed(2) + " " + products[0]["defaultCurrency"];

            tableContainer.appendChild(table);
            tableContainer.appendChild(totalPriceDiv);

            return tableContainer;
    }
}