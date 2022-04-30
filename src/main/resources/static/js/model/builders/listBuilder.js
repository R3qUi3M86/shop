import { buttonBuilder, buttonTypes } from "./buttonBuilder.js";

export const listTypes = {
    categoryList: "category list",
    supplierList: "supplier list"
}

export function listBuilder(listType, elementArray){
    switch (listType){
        case listTypes.categoryList:
            return categoryListBuilder(elementArray);
        case listTypes.supplierList:
            return supplierListBuilder(elementArray);
    }
}

function categoryListBuilder(elementArray) {
    const catListContainer = document.createElement("div");
    catListContainer.id = "categoryListContainer";
    catListContainer.classList.add("list-group");
    const button = buttonBuilder(buttonTypes.categoryBtn);
    button.classList.add("active")
    button.setAttribute("data-category-id", `0`);
    button.innerText = "All";
    catListContainer.appendChild(button);
    for (let elem of elementArray) {
        const button = buttonBuilder(buttonTypes.categoryBtn);
        button.id = elem.name + "SelectButton";
        button.setAttribute("data-category-id", `${elem.id}`);
        button.innerText = elem.name;
        catListContainer.appendChild(button);
    }
    return catListContainer;
}
function supplierListBuilder(elementArray) {
    const supListContainer = document.createElement("div");
    supListContainer.id = "supplierListContainer";
    supListContainer.classList.add("list-group");
    const button = buttonBuilder(buttonTypes.categoryBtn);
    button.classList.add("active")
    button.setAttribute("data-supplier-id", `0`);
    button.innerText = "All";
    supListContainer.appendChild(button);
    for (let elem of elementArray) {
        const button = buttonBuilder(buttonTypes.categoryBtn);
        button.id = elem.name + "SelectButton";
        button.setAttribute("data-supplier-id", `${elem.id}`);
        button.innerText = elem.name;
        supListContainer.appendChild(button);
    }
    return supListContainer;
}