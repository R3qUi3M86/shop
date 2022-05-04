import {htmlFactory, htmlTemplates} from "../model/htmlFactory.js";
import {buttonTypes} from "../model/builders/buttonBuilder.js";
import {listTypes} from "../model/builders/listBuilder.js";
import {dataHandler} from "../model/dataHandler.js";
import {domManager} from "../view/domManager.js";
import {btnActionController} from "./btnActionController.js";

export const filterController = {
    async initCategoryFilter(){
        const categoryArr = await dataHandler.getAllCategoryNames();
        const listBuilder = htmlFactory(htmlTemplates.list);
        const categoryContainer = listBuilder(listTypes.categoryList, categoryArr);
        domManager.addChild("catContainer", categoryContainer);
        btnActionController.setCategoryButtonsEvtHandlers();
    },

    async initSupplierFilter() {
        const supplierArr = await dataHandler.getAllSupplierNames();
        const listBuilder = htmlFactory(htmlTemplates.list);
        const supplierContainer = listBuilder(listTypes.supplierList, supplierArr);
        domManager.addChild("supContainer", supplierContainer);
        btnActionController.setSupplierButtonsEvtHandlers();
    },

    async initAllProducts() {
        const products = await dataHandler.getProductsByCustomFilter(0,0);
        domManager.clearProductsContainer();
        domManager.displayProducts(products);
        btnActionController.setProductBuyEvtHandlers();
    }
}