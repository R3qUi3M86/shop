export const buttonTypes = {
    categoryBtn: "category button",
    productBtn: "product button",
    increaseProductAmt: "increase product amt",
    decreaseProductAmt: "decrease product amt",
    addRemoveProductBtnGroup: "add or remove product button group"
}

export function buttonBuilder(buttonType, content) {
    const button = document.createElement("button");
    button.setAttribute("type", "button");

    switch (buttonType){
        case (buttonTypes.categoryBtn):
            button.classList.add("list-group-item", "list-group-item-action");
            return button;

        case (buttonTypes.productBtn):
            button.classList.add("btn", "btn-primary", "buy-btn");
            button.setAttribute("data-product-id", content);
            button.innerText = "Add to cart"
            return button;

        case (buttonTypes.increaseProductAmt):
            button.classList.add("btn", "px-1", "py-0", "btn-outline-secondary");
            button.id = "addProductBtn";
            const plusIcon = document.createElement("i");
            plusIcon.classList.add("bi", "bi-cart-plus");
            button.appendChild(plusIcon);
            return button;

        case (buttonTypes.decreaseProductAmt):
            button.classList.add("btn", "px-1", "py-0", "btn-outline-secondary");
            button.id = "removeProductBtn";
            const minusIcon = document.createElement("i");
            minusIcon.classList.add("bi", "bi-cart-dash");
            button.appendChild(minusIcon);
            return button;

        case (buttonTypes.addRemoveProductBtnGroup):
            const addRemoveBtnGroup = document.createElement("div");
            addRemoveBtnGroup.classList.add("btn-group");
            addRemoveBtnGroup.setAttribute("role", "group");
            const removeBtn = buttonBuilder(buttonTypes.decreaseProductAmt);
            const addBtn = buttonBuilder(buttonTypes.increaseProductAmt);
            addRemoveBtnGroup.appendChild(removeBtn);
            addRemoveBtnGroup.appendChild(addBtn);
            return addRemoveBtnGroup;

    }
}