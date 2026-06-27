# dl-java: Deep Neural Networks from Scratch in Java (2015)

**One of my earliest deep learning projects — a complete neural network framework built entirely from scratch in Java with no external ML libraries.**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

## 🎯 Goal / Motivation

Built in **2015**, this repository represents my early exploration into the inner workings of neural networks. At the time, modern frameworks like TensorFlow and PyTorch did not exist (or were very new), so implementing everything from first principles was one of the best ways to truly understand the field.

## ✨ Features

- Full implementation of backpropagation
- Dense layers, Convolutional layers, and multi-layer networks
- Activation functions (ReLU, Sigmoid, Tanh, Softmax)
- Loss functions
- SGD Optimizer with several training features (src/optim/sgd/SGDOptim.java): Supports mini-batch training, learning rate annealing, live loss plotting, and model persistence.
- A complete **LeNet-5** convolutional network example in `src/main/RunLeNet.java`

## 🧠 Core Concepts Implemented

- Matrix multiplication and linear algebra operations
- Forward and backward passes
- Differentiation via actual calculated differentials
- Gradient descent optimization
- Mini-batch training
- Convolutions implemented via brute force and using fast-fourier transform

## 🧪 Complete Working Example: LeNet-5

A full implementation of the classic **LeNet-5** convolutional network is included:

- `src/main/RunLeNet.java` — Trains and evaluates LeNet on a digit classification task (MNIST-style).

This example showcases:
- Convolutional layer logic
- Pooling operations
- End-to-end training pipeline
- Proper forward/backward pass integration
