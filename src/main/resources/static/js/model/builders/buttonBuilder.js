export const buttonTypes = {
    categoryBtn: "category button"
}

export function buttonBuilder(buttonType) {
    const button = document.createElement("button");
    button.setAttribute("type", "button");

    switch (buttonType){
        case (buttonTypes.categoryBtn):
            button.classList.add("list-group-item", "list-group-item-action");
            return button;
    }
}