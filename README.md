Student Course Management System
Overview
A course enrollment management system that handles student registration, course management, and enrollment operations with undo/redo capabilities.
Core Components
Student Management
•	Maintains a sorted list of students using a doubly-linked list
•	Each student has: ID, name, age, and GPA
•	Supports adding and removing students
•	Uses merge sort for maintaining sorted order
•	Implements binary search for efficient student lookup


Course Management
•	Maintains a sorted list of courses using a doubly-linked list
•	Each course has: ID, name, and enrollment capacity
•	Supports adding and removing courses
•	Uses merge sort for maintaining sorted order
•	Implements binary search for efficient course lookup


Enrollment System
•	Manages student-course relationships
•	Bidirectional linking between students and courses
•	Supports course enrollment and withdrawal
•	Maintains enrollment limits per course
•	Tracks student grades in enrolled courses



Undo/Redo Functionality
•	Tracks enrollment actions
•	Supports undoing recent enrollment operations
•	Allows redoing previously undone actions
•	Maintains consistency in enrollment states


Key Features
•	Student operations (add, remove, search)
•	Course operations (add, remove, search)
•	Enrollment management
•	Grade tracking
•	Course capacity management
•	Undo/Redo capability
•	Sorted list maintenance
•	Performance optimized searching


Data Structures
•	Doubly-linked lists for students and courses
•	Stack implementation for undo/redo operations
•	Binary search implementation for efficient lookups


The system provides a comprehensive solution for managing student enrollments while maintaining data integrity and offering the flexibility to reverse actions through its undo/redo system.

