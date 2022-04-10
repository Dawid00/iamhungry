# I am hungry

This is a small client api which takes the recipes from https://rapidapi.com/apidojo/api/yummly2.
I used an okHttpClient to communicate with api and Gson to map JSON objects to Java objects.


## API Reference

#### Get random recipe

```http
  GET /api/recipes/one
```

#### Get recipes by name 

```http
  GET /api/recipes
```

| Parameter | Type     | Description                                                            |
|:----------|:---------|:-----------------------------------------------------------------------|
| `name`    | `string` | **Required**. Name of recipe or ingredient in recipe                   |
| `start`   | `int`    | **Optional**. The offset of items to be ignored in response for paging |
| `limit`   | `int`    | **Optional**. Number of items returned per response                    |

Example Request
```http 
GET http://localhost:9000/api/recipes?name=egg&limit=3&start=32
```