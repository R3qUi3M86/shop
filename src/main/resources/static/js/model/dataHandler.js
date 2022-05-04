export const dataHandler = {
    getProductsByCategory: async function (categoryId) {
        return await apiPost("/product/findByCategory", categoryId);
    },

    getAllCategoryNames: async function (){
        return await apiGet("/category/findAll");
    },

    addProductToCart: async function (payload){
        return await apiPost("/cart/addProduct", payload);
    },

    removeProductFromCart: async function (payload){
        return await apiPost("/cart/removeProduct", payload);
    },

    getAllSupplierNames: async function (){
        return await apiGet("/supplier/findAll");
    },

    getProductsByCustomFilter: async function (supplierId, categoryId) {
        return await apiGet('product/filter?' + new URLSearchParams({
                categoryId: categoryId,
                supplierId: supplierId,
        }))
    },

    getUserOrder: async function (userName){
        return await apiPost("/order/find", {"userName": userName})
    },

    emptyCart: async function (userName){
        return await apiPost("/order/clear", {"userName": userName})
    },
};

async function apiGet(url) {
    let response = await fetch(url, {
        method: "GET",
    });
    if (response.status === 200) {
        return response.json();
    }
}

async function apiPost(url, payload) {
    let response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(payload),
        headers: {'Content-Type': 'application/json'}
    });
    if (response.status === 200) {
        return response.json();
    }
}

async function apiDelete(url, payload) {
    let response = await fetch(url, {
        method: "DELETE",
        body: JSON.stringify(payload),
        headers: {'Content-Type': 'application/json'}
    });
    if (response.status === 200) {
        return response.json();
    }
}

async function apiPut(url, payload) {
    let response = await fetch(url, {
        method: "PUT",
        body: JSON.stringify(payload),
        headers: {'Content-Type': 'application/json'}
    });
    if (response.status === 200) {
        return response.json();
    }
}

function logResponseStatus(response){
    if (response['status'] === 'empty_title') {
        console.error('Server received empty title!');
    } else if (response['status'] === 'id_change') {
        console.info('Default column name change -> generated new column.');
    }
}