/* global NumberFormatter */

"use strict";
var productsApi = '//localhost:8080/api/products';
var categoriesApi = '//localhost:8080/api/categories';
var categoriesFilterApi = ({category}) => `//localhost:8080/api/categories/${category}`;

const app = Vue.createApp({

    data() {
        return {
            products: new Array(),
            categories: new Array()
        };
    },

    mounted() {
        // semicolon separated statements

        this.getAllProducts();
        this.getAllCatagories();

    },

    methods: {
        // comma separated function declarations
        getAllProducts() {

            axios.get(productsApi)
                    .then(response => {
                        this.products = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        },
        getAllCatagories() {
            axios.get(categoriesApi)
                    .then(response => {
                        this.categories = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        },

        filterByCategory(category) {
            axios.get(categoriesFilterApi({'category': category}))
                    .then(response => {
                        this.products = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        buyProduct(product) {
            dataStore.commit("selectProduct", product);
            window.location = "quantityToPurchase.html"
        },
        mixins: [NumberFormatter]
    }

});

// other component imports go here
import { NumberFormatter } from './number-formatter.js';
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);
import { dataStore } from './data-store.js'
        app.use(dataStore);
app.mount("#content");

