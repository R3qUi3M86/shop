import { buttonBuilder } from "./builders/buttonBuilder.js";
import { cardBuilder } from "./builders/cardBuilder.js";
import { formBuilder } from "./builders/formBuilder.js";
import { listBuilder } from "./builders/listBuilder.js";
import { basketBuilder } from "./builders/basketBuilder.js";

export const htmlTemplates = {
    card: 0,
    list: 1,
    button: 2,
    form: 4,
    basket: 5
}

export function htmlFactory(template) {
    switch (template) {
        case htmlTemplates.card:
            return cardBuilder;
        case htmlTemplates.list:
            return listBuilder;
        case htmlTemplates.button:
            return buttonBuilder;
        case htmlTemplates.form:
            return formBuilder;
        case htmlTemplates.basket:
            return basketBuilder;
        default:
            console.error("Undefined template: " + template)
            return () => { return "" }
    }
}