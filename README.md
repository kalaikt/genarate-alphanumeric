# Generate alphanumeric

Generate a list of all possible combinations of alpha-numeric phone numbers from the input phone number. Display the total count at the beginning.

## Usage

Combinations list by page

#### Definition

`GET /generate/alphanumeric/{phoneNumber}/{pageNumber}`


#### Response

* 200 OK on success

``` {
    count: total count,
    data: list of alphanumeric combinations per page,
    error?: error message
} ```