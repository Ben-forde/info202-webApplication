/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global NumberFormatter */

"use strict";
var saleApi = '//localhost:8080/api/sales';
class SaleItem {
    constructor(product, quantityPurchased) {
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.salePrice = product.listPrice;
    }
}

class Sale {
    constructor(customer, items) {
        this.customer = customer;
        this.items = items;
    }
}
const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
            quantity: 1
        };
    },

    computed: Vuex.mapState({
        product: 'selectedProduct',
        items: 'items',
        customer: 'customer'
    }),

    mounted() {
        // semicolon separated statements


    },

    methods: {
        // comma separated function declarations
        addToCart() {
            dataStore.commit("addItem", new SaleItem(this.product, this.quantity));
            window.location = "Cart.html";
        },
        checkOut() {
            let sale = new Sale(this.customer, this.items);
            axios.post(saleApi, sale)

                    .then(() => {
                        dataStore.commit("clearItems");
                        window.location = "Confirmation.html";
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        },
        // clear cart items
        clearItems(state) {
            state.items = new Array();
        },
        getItemTotal(item) {
            return item.salePrice * item.quantityPurchased;
        },
        getGrandTotal() {
            var grandTotal = 0;
            for (var i = 0; i < this.items.length; i++) {
                grandTotal = grandTotal + (this.items[i].salePrice * this.items[i].quantityPurchased);
            }
            return grandTotal;   
        }

    },
    mixins: [NumberFormatter]
});

/* other component imports go here */

// import data store
import { dataStore } from './data-store.js'
        app.use(dataStore);
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);
import { NumberFormatter } from './number-formatter.js';

// mount the page - this needs to be the last line in the file
app.mount("#content");
