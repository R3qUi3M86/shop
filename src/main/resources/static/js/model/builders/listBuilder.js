import { buttonBuilder, buttonTypes } from "./buttonBuilder.js";

export const listTypes = {
    categoryList: "category list"
}

export function listBuilder(listType, elementArray){
    switch (listType){
        case listTypes.categoryList:
            const catListContainer = document.createElement("div");
            catListContainer.id = "categoryListContainer";
            catListContainer.classList.add("list-group");
            for (let elem of elementArray){
                const button = buttonBuilder(buttonTypes.categoryBtn);
                button.id = elem.name + "SelectButton";
                button.setAttribute("data-category-id", `${elem.id}`);
                button.innerText = elem.name;
                catListContainer.appendChild(button);
            }
            return catListContainer;
    }
}