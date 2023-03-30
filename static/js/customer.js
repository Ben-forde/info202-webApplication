/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";


var registerApi = '/api/register';
var customerApi = ({username}) => `//localhost:8080/api/customers/${username}`;

const app = Vue.createApp({

    data() {
        return {
            customer: new Object(),
            signInMessage: "Please sign in to continue."


        };
    },

    mounted() {
        // semicolon separated statements

  

    },

    methods: {
        // comma separated function declarations
        registerCustomer() {
            axios.post(registerApi, this.customer)
                    .then(() => {
                        window.location = 'ViewProducts.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        signIn() {
            axios.get(customerApi({'username': this.customer.username}))
                    .then(response => {
                        this.customer = response.data;
                        dataStore.commit("signIn", this.customer);
                       
                        window.location = 'Viewproducts.html';
                    })
                    .catch(error => {
                        this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                    });
        }
    }

});

// other component imports go here


// mount the page - this needs to be the last line in the file
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);
import { dataStore } from './data-store.js'
app.use(dataStore);
app.mount("#content");
