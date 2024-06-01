# Quiz Management REST API

This project is a Quiz Management REST API built with Spring Boot. It provides endpoints for managing quizzes and questions, including creating quizzes, retrieving questions by category, and calculating quiz results. 

## Table of Contents

- [Overview](#overview)
- [Endpoints](#endpoints)
  - [Questions](#questions)
    - [Get All Questions](#get-all-questions)
    - [Get Questions by Category](#get-questions-by-category)
    - [Add a Question](#add-a-question)
  - [Quizzes](#quizzes)
    - [Create a Quiz](#create-a-quiz)
    - [Get Quiz Questions](#get-quiz-questions)
    - [Submit Quiz](#submit-quiz)
- [Data Models](#data-models)
  - [Question](#question)
  - [QuestionWrapper](#questionwrapper)
  - [Quiz](#quiz)
  - [Response](#response)
- [Error Handling](#error-handling)


## Overview

The Quiz Management REST API allows users to create and manage quizzes. It supports operations to add questions, categorize them, create quizzes from these questions, retrieve questions by category, and evaluate quiz responses.

## Endpoints

### Questions

#### Get All Questions

- **URL:** `GET /questions/allquestions`
- **Description:** Retrieves all questions from the database.
- **Response:**
  - **200 OK:** Returns a list of all questions.
  - **500 Internal Server Error:** If there is an issue retrieving the questions.
 
  
    ![Screenshot 2024-06-01 195502](https://github.com/Kedhar193/full-stack-projects/assets/115712936/ec5e592f-2e4c-41ce-b309-223f132a723c)


#### Get Questions by Category

- **URL:** `GET /questions/category/{category}`
- **Description:** Retrieves questions based on the specified category.
- **Path Variable:** `category` (String) - The category of questions to retrieve.
- **Response:**
  - **200 OK:** Returns a list of questions in the specified category.
  - **500 Internal Server Error:** If there is an issue retrieving the questions.

![Screenshot 2024-06-01 195548](https://github.com/Kedhar193/full-stack-projects/assets/115712936/5f9465dd-62f5-4615-9f33-0f29e1b1d734)


#### Add a Question

- **URL:** `POST /questions/add`
- **Description:** Adds a new question to the database.
- **Request Body:** `Question` - The question object to add.
- **Response:**
  - **201 Created:** If the question is added successfully.
  - **400 Bad Request:** If there is an issue adding the question.
 
    ![Screenshot 2024-06-01 195959](https://github.com/Kedhar193/full-stack-projects/assets/115712936/e9d37817-8c8d-4516-b1de-1b9d7b6315d2)


### Quizzes

#### Create a Quiz

- **URL:** `POST /quiz/create`
- **Description:** Creates a new quiz with a specified number of questions from a specified category.
- **Request Parameters:**
  - `category` (String) - The category of questions to include in the quiz.
  - `numq` (int) - The number of questions in the quiz.
  - `title` (String) - The title of the quiz.
- **Response:**
  - **201 Created:** If the quiz is created successfully.
  - **400 Bad Request:** If there is an issue creating the quiz.
 
    ![Screenshot 2024-06-01 200926](https://github.com/Kedhar193/full-stack-projects/assets/115712936/51bccee2-0b82-4ab6-9473-ba7100258f30)


#### Get Quiz Questions

- **URL:** `GET /quiz/get/{id}`
- **Description:** Retrieves the questions for a specified quiz.
- **Path Variable:** `id` (Integer) - The ID of the quiz.
- **Response:**
  - **200 OK:** Returns a list of `QuestionWrapper` objects for the quiz.
  - **404 Not Found:** If the quiz with the specified ID does not exist.

![Screenshot 2024-06-01 202322](https://github.com/Kedhar193/full-stack-projects/assets/115712936/e97d3be2-8be7-4511-b161-eb3a2880bd70)


#### Submit Quiz

- **URL:** `POST /quiz/submit/{id}`
- **Description:** Submits responses for a quiz and calculates the result.
- **Path Variable:** `id` (Integer) - The ID of the quiz.
- **Request Body:** List of `Response` objects containing the user's answers.
- **Response:**
  - **200 OK:** Returns the number of correct answers.
  - **404 Not Found:** If the quiz with the specified ID does not exist.
  - **400 Bad Request:** If there is an issue with the submitted responses.
 
    ![Screenshot 2024-06-01 202827](https://github.com/Kedhar193/full-stack-projects/assets/115712936/196ef42c-649a-48d9-a8c9-d1b8c97aa256)


## Data Models

### Question

- **id** (int): Unique identifier for the question.
- **questionDescription** (String): The text of the question.
- **option1** (String): First option.
- **option2** (String): Second option.
- **option3** (String): Third option.
- **option4** (String): Fourth option.
- **correctOption** (String): The correct option.
- **category** (String): The category of the question.

### QuestionWrapper

- **id** (Integer): Unique identifier for the question.
- **questionTitle** (String): The text of the question.
- **option1** (String): First option.
- **option2** (String): Second option.
- **option3** (String): Third option.
- **option4** (String): Fourth option.

### Quiz

- **id** (Integer): Unique identifier for the quiz.
- **title** (String): Title of the quiz.
- **questions** (List\<Question>): List of questions included in the quiz.

### Response

- **id** (Integer): Unique identifier for the response.
- **response** (String): The user's answer to the question.

## Error Handling

The API uses appropriate HTTP status codes to indicate success or failure of operations:
- **200 OK:** Operation successful.
- **201 Created:** Resource successfully created.
- **400 Bad Request:** Invalid request data.
- **404 Not Found:** Resource not found.
- **500 Internal Server Error:** Server encountered an error.

## Conclusion

This Quiz Management REST API provides essential endpoints to create and manage quizzes effectively. The detailed endpoints facilitate various operations like adding questions, categorizing them, creating quizzes, and evaluating quiz results. The structured error handling and logging ensure robustness and maintainability of the application.

## Source

link to the youtube video : https://youtu.be/vlz9ina4Usk?si=YKkwCjQTmznSPIRf

I built this project by following a tutorial on YouTube. It was a great way to learn about springboot framework , spring data jpa and restful services .
