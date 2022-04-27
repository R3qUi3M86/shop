export const domManager = {
    addChild(parentId, child){
        const parent = document.getElementById(parentId);
        if (parent){
            parent.appendChild(child);
        } else {
            console.error("could not find such html element: " + parentId);
        }
    },

    deactivateAllCategories(){
        const categoryBtnsParent = document.getElementById("categoryListContainer");
        const categoryElemArray = Array.from(categoryBtnsParent.children);
        categoryElemArray.forEach((e) => {
            e.classList.remove("active");
        })
    }
}