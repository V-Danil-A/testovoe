package com.danil.util

interface Reducer<S: State, A: Action> {

    fun reduce(currentState: S, action: A): S
}