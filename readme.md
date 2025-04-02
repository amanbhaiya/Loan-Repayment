# Loan Repayment API

## Overview
This Spring Boot project calculates the repayment schedule for a loan based on given inputs. It provides an API to calculate and return the repayment schedule using simple interest.

## Prerequisites
- JDK 17+
- Maven
- Spring Boot

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/loan-repayment-api.git
   cd loan-repayment-api
   ```
2. Build the project using Maven:
   ```sh
   mvn clean install
   ```
3. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

## API Details
### Endpoint: Calculate Repayment Schedule
- **URL:** `POST /api/loan/schedule`
- **Content-Type:** `application/json`

### Request Body
```json
{
    "loanAmount": 10000,
    "tenure": 10,
    "rateOfInterest": 10,
    "repaymentType": "weekly"
}
```

### Response Example
```json
[
    {
        "sno": 1,
        "date": "07-04-2024",
        "day": "SUNDAY",
        "outstandingLoanAmountOnStartDay": 10000.0,
        "dueInterest": 83.33,
        "emi": 1041.67,
        "outstandingLoanAmountOnEndDay": 9000.0
    },
    ...
]
```

## Validation Rules
- `loanAmount` and `tenure` must be positive numbers.
- `rateOfInterest` must be a valid percentage.
- `repaymentType` must be either `weekly` or `monthly`.

## Notes
- Uses simple interest calculation.
- Dates are formatted as `dd-MM-yyyy`.

## License
MIT License.