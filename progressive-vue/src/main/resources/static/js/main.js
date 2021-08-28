const App = {
    data() {
        return {
            cartTotal: 0,
            products: [],
            product: {
                id: null,
                name: '',
                price: '',
                category: '',
            },
            currentProduct: null,
            isSaving: false,
            isSaved: false
        }
    },
    methods: {
        onAddToCart($event) {
            const id = $event.target.id.value;
            this.currentProduct = id;
            this.product.id = id;
            this.product.name = $event.target.name.value;
            this.product.price = $event.target.price.value;
            this.product.category = $event.target.category.value;

            this.isSaving = true;
            (async () => {
                const rawResponse = await fetch('/api/cart', {
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(this.product)
                });
                const updated = await rawResponse.json();
                this.isSaved = true;
                this.currentProduct = null;
                this.cartTotal += 1;
                setTimeout(() => {
                    this.isSaved = false;
                },5000);
            })();
        },
    },
    async mounted() {
        let response = await fetch("/api/products");
        this.products = await response.json();
    }

}
Vue.createApp(App).mount("#app");
