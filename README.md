# CI/CD with Jenkins + GitHub + ngrok

This repository demonstrates how to automatically trigger a Jenkins pipeline job when a commit is pushed to GitHub.  
We use **ngrok** to expose Jenkins running locally to the internet.

The project being built and deployed here is a **Scientific Calculator implemented in Java**.

---

## ⚙️ Prerequisites
- [Jenkins](https://www.jenkins.io/) installed and running locally (port `8080` by default).
- [ngrok](https://ngrok.com/) installed and authenticated.
- A Jenkins pipeline job already created.
- Java installed (since the Scientific Calculator project is written in Java).

---

## 🚀 Setup

### 1. Start Jenkins
Run Jenkins locally (default at `http://localhost:8080`).

### 2. Start ngrok
Expose Jenkins using ngrok:
```bash
ngrok http 8080
