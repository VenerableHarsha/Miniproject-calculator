# CI/CD Pipeline for a Containerized Java Calculator

This project demonstrates the construction of a complete CI/CD pipeline for a Java-based calculator application.  
The pipeline automates compilation, testing, containerization, and deployment using widely adopted DevOps tools.

The objective of this project is to demonstrate how modern development workflows integrate source control, build automation, containerization, and configuration management to produce a fully reproducible deployment pipeline.

---

# Project Architecture

The CI/CD pipeline integrates several tools to automate the transition from source code to a deployed application.

**Technologies Used**

- **GitHub** – Source code hosting and version control
- **Jenkins** – Continuous Integration and Continuous Deployment automation
- **Maven** – Java build and dependency management tool
- **Docker** – Containerization platform
- **Docker Hub** – Container registry used for image storage
- **Ansible** – Deployment automation and configuration management

**Pipeline Workflow**

```
Developer → GitHub → Jenkins → Maven Build & Test → Docker Image Build → Docker Hub → Ansible Deployment
```

---

# Repository Structure

```
Miniproject-calculator
│
├── Calculator/          # Java calculator source code (Maven project)
├── Dockerfile           # Docker image build configuration
├── Jenkinsfile          # Jenkins CI/CD pipeline definition
├── deploy.yml           # Ansible deployment playbook
├── inventory.ini        # Ansible deployment inventory
└── README.md
```

---

# Development and Execution Environment

This project was implemented using a hybrid Windows and Linux development environment.

| Component | Environment |
|--------|--------|
| Development | Windows + IntelliJ IDEA |
| CI/CD Execution | WSL Ubuntu |
| Automation Tools | Jenkins, Docker, Maven, Ansible (running inside WSL) |
| Deployment Target | Fresh Ubuntu container |

### Environment Setup

The source code was developed using **IntelliJ IDEA on Windows**.  
The CI/CD pipeline components such as Jenkins, Docker, Maven, and Ansible were executed inside **WSL Ubuntu**.

For deployment testing, a **fresh Ubuntu container** was used as the target environment.

To improve performance and avoid nested container services, the deployment container **uses the Docker daemon running in the WSL host environment rather than running its own Docker service**.

---

# Prerequisites

Before running the project, install the following tools.

### Required Software

- Git
- Java JDK 17 or later
- Maven
- Docker
- Jenkins
- Ansible

---

# Installing Dependencies (Ubuntu / WSL)

Update the package list:

```bash
sudo apt update
```

Install required tools:

```bash
sudo apt install openjdk-17-jdk maven docker.io ansible git
```

Start Docker:

```bash
sudo systemctl start docker
```

Allow the current user to run Docker:

```bash
sudo usermod -aG docker $USER
```

Log out and log back in after executing this command.

---

# Cloning the Repository

Clone the project repository:

```bash
git clone https://github.com/VenerableHarsha/Miniproject-calculator.git
```

Move into the project directory:

```bash
cd Miniproject-calculator
```

---

# Running the Calculator Locally

The calculator application can be executed directly using Maven before containerization.

Navigate to the project directory:

```bash
cd Calculator
```

Compile the project:

```bash
mvn clean compile
```

Run the unit tests:

```bash
mvn test
```

Package the application:

```bash
mvn package
```

This generates a runnable **JAR file** in the `target/` directory.

Run the calculator application:

```bash
java -jar target/calculator.jar
```

---

# Building the Docker Image

Return to the root project directory:

```bash
cd ..
```

Build the Docker image:

```bash
docker build -t calculator-app .
```

Verify the image exists:

```bash
docker images
```

Run the container:

```bash
docker run -it calculator-app
```

---

# Jenkins Pipeline Setup

Start Jenkins and open it in your browser:

```
http://localhost:8080
```

Follow these steps:

1. Install the recommended Jenkins plugins
2. Create a **New Pipeline Job**
3. Connect the job to this GitHub repository
4. Configure Jenkins to build using the **Jenkinsfile** located in the repository

---

# Jenkins Pipeline Stages

The Jenkins pipeline performs the following automated steps:

### 1. Build Stage
Jenkins compiles the Java source code using Maven.

### 2. Test Stage
JUnit tests are executed to verify the correctness of the calculator's mathematical operations.

### 3. Package Stage
The compiled application is packaged into a runnable **JAR file**.

### 4. Docker Image Build
Docker constructs a container image containing the calculator application and its runtime environment.

### 5. Docker Push
The container image is pushed to **Docker Hub** so that it can be accessed during deployment.

### 6. Deployment
Ansible pulls the container image and launches the calculator container in the deployment environment.

---

# Docker Hub Setup

Create a repository on Docker Hub:

```
https://hub.docker.com
```

Example repository:

```
https://hub.docker.com/r/<username>/calculator-app
```

Add Docker Hub credentials to Jenkins:

```
Manage Jenkins → Credentials → Add Credentials
```

These credentials allow Jenkins to authenticate and push images to Docker Hub.

---

# Deployment Using Ansible

The deployment process is automated using the Ansible playbook.

Inventory file:

```
inventory.ini
```

Deployment playbook:

```
deploy.yml
```

Run deployment manually using:

```bash
ansible-playbook -i inventory.ini deploy.yml
```

The playbook performs the following operations:

1. Connects to the deployment host
2. Pulls the latest Docker image from Docker Hub
3. Starts the calculator container

---

# Running the Complete Pipeline

The entire CI/CD pipeline can be executed automatically through Jenkins.

Pipeline execution performs the following sequence:

1. Clone the repository from GitHub
2. Compile the Java source code
3. Run automated unit tests
4. Package the application
5. Build the Docker container image
6. Push the image to Docker Hub
7. Deploy the container using Ansible

After successful execution, the calculator application runs inside a Docker container in the deployment environment.

---

# Author

Harsha  
IIIT Bangalore
