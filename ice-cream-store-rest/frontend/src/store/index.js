import { createStore, createLogger } from 'vuex'

const state= {
    cartTotal: 0
}

const actions = {
    updateCartTotal({ commit }) {
        commit('INCREMENT_CART_TOTAL')
    },
}

const mutations = {
    INCREMENT_CART_TOTAL(state) {
        state.cartTotal++;
    },
}

const store = createStore({
    state,
    mutations,
    actions
})

export default store
