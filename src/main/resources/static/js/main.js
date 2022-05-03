import {filterController} from "./controller/filterController.js";
import {btnActionController} from "./controller/btnActionController.js";

filterController.initCategoryFilter();
filterController.initSupplierFilter();
filterController.initAllProducts();
btnActionController.setCartShowEvtHandler();
btnActionController.setEmptyCartEvtHandler();
btnActionController.setCheckoutEvtHandler();
