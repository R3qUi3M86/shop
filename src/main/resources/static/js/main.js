

export let dataHandler = {
    getBoards: async function (payload) {
        const response = await apiPost("/", payload);
        return response;
    },

    getProductsByCategory: async function (categoryId) {
        const response = await apiGet(`/display-products/${categoryId}`);
        console.log(response)
        return response;
    },
};

let filterBtn = document.getElementById("filterBtn")
let categorySelect = document.getElementById("category-select")

filterBtn.onclick = function(){
    dataHandler.getProductsByCategory(categorySelect.value).then(value => displayProducts(value))
}

function displayProducts(value) {
    let productsContainer = document.getElementById("products")
    productsContainer.innerHTML = ""
    for (const element of value) {
        let bDiv = document.createElement("div")
        bDiv.setAttribute("class", "col col-sm-12 col-md-6 col-lg-4")
        productsContainer.appendChild(bDiv)

        let newProductCard = document.createElement("div")
        bDiv.appendChild(newProductCard)
        newProductCard.setAttribute("class", "card")
        let cardHeader = document.createElement("div")
        newProductCard.appendChild(cardHeader)
        let cardTitle = document.createElement("h4")
        cardHeader.appendChild(cardTitle)
        cardTitle.innerText = element["name"]
        let cardDescription = document.createElement("p")
        cardHeader.appendChild(cardDescription)
        cardDescription.innerText = element["description"]
        let cardBody = document.createElement("p")
        newProductCard.appendChild(cardBody)
        cardBody.innerText = element["defaultPrice"] + " " + element["defaultCurrency"]


        console.log(element)
    }

}


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

// console.log(await dataHandler.getBoards({asd: ["dupa", "dupa2"]}))

