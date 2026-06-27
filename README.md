# dl-java: Deep Neural Networks from Scratch in Java

**A clean, educational Java framework for building and training deep neural networks without external ML libraries.**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

## 🎯 Goal / Motivation

This project was built to deeply understand the **mathematical and computational foundations** of modern deep learning. By implementing everything from first principles in Java, I gained strong insight into backpropagation, memory management, matrix operations, and optimization algorithms.

## ✨ Features

- **Fully custom neural network layers** (Dense/Fully Connected)
- **Activation functions**: ReLU, Sigmoid, Tanh, Softmax
- **Loss functions**: MSE, Cross-Entropy
- **Optimizers**: Gradient Descent, (optionally) Momentum, Adam
- **Backpropagation** implemented from scratch
- **Weight initialization** strategies (Xavier, He)
- **Support for multi-layer networks**
- Pure Java — no TensorFlow, PyTorch, ND4J, or other ML libraries

## 🧠 Core Concepts Implemented

- Matrix multiplication and linear algebra operations
- Forward and backward passes
- Automatic differentiation (via backprop)
- Gradient descent optimization
- Mini-batch training
- ...

## 📁 Project Structure
src/
├── main/
│   ├── java/
│   │   ├── nn/              # Core neural network classes
│   │   ├── math/            # Matrix, Vector, Linear Algebra
│   │   ├── activation/      # Activation functions
│   │   ├── loss/            # Loss functions
│   │   └── optimizer/       # Optimizers
│   └── resources/

## 🧪 Complete Working Example: LeNet-5

A full implementation of the classic **LeNet-5** convolutional network is included:

- `src/main/RunLeNet.java` — Trains and evaluates LeNet on a digit classification task (MNIST-style).

This example showcases:
- Convolutional layer logic
- Pooling operations
- End-to-end training pipeline
- Proper forward/backward pass integration