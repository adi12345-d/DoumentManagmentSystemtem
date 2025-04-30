# DoumentManagmentSystemtem Docker Conterizartion 

# Use the official OpenJDK image
FROM openjdk:17-jre-slim

# Set the working directory
WORKDIR /app

# Copy the jar file
COPY target/document-management-app.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]





name: CI/CD Pipeline

on:
  push:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v2

      - name: Set up JDK 17
        uses: actions/setup-java@v1
        with:
          java-version: '17'

      - name: Build Backend
        run: |
          cd backend
          ./mvnw clean package

      - name: Build Frontend
        run: |
          cd frontend
          npm install
          npm run build

      - name: Run Tests
        run: |
          cd backend
          ./mvnw test
          cd ../frontend
          npm test

      - name: Deploy to Docker Hub
        run: |
          docker build -t my-backend ./backend
          docker build -t my-frontend ./frontend
          echo "${{ secrets.DOCKER_PASSWORD }}" | docker login -u "${{ secrets.DOCKER_USERNAME }}" --password-stdin
          docker push my-backend
          docker push my-frontend
