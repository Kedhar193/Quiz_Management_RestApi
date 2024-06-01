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

#### Get Questions by Category

- **URL:** `GET /questions/category/{category}`
- **Description:** Retrieves questions based on the specified category.
- **Path Variable:** `category` (String) - The category of questions to retrieve.
- **Response:**
  - **200 OK:** Returns a list of questions in the specified category.
  - **500 Internal Server Error:** If there is an issue retrieving the questions.

#### Add a Question

- **URL:** `POST /questions/add`
- **Description:** Adds a new question to the database.
- **Request Body:** `Question` - The question object to add.
- **Response:**
  - **201 Created:** If the question is added successfully.
  - **400 Bad Request:** If there is an issue adding the question.

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

#### Get Quiz Questions

- **URL:** `GET /quiz/get/{id}`
- **Description:** Retrieves the questions for a specified quiz.
- **Path Variable:** `id` (Integer) - The ID of the quiz.
- **Response:**
  - **200 OK:** Returns a list of `QuestionWrapper` objects for the quiz.
  - **404 Not Found:** If the quiz with the specified ID does not exist.

#### Submit Quiz

- **URL:** `POST /quiz/submit/{id}`
- **Description:** Submits responses for a quiz and calculates the result.
- **Path Variable:** `id` (Integer) - The ID of the quiz.
- **Request Body:** List of `Response` objects containing the user's answers.
- **Response:**
  - **200 OK:** Returns the number of correct answers.
  - **404 Not Found:** If the quiz with the specified ID does not exist.
  - **400 Bad Request:** If there is an issue with the submitted responses.

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
