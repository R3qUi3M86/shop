export const buttonTypes = {
    categoryBtn: "category button",
    productBtn: "product button"
}

export function buttonBuilder(buttonType, content) {
    const button = document.createElement("button");
    button.setAttribute("type", "button");

    switch (buttonType){
        case (buttonTypes.categoryBtn):
            button.classList.add("list-group-item", "list-group-item-action");
            return button;
        case (buttonTypes.productBtn):
            button.classList.add("btn", "btn-primary");
            console.log(content)
            button.setAttribute("product-id", content);
            button.innerText = "Add to cart"
            return button;
    }
}