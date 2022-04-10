# I am hungry

This is a small client api which takes the recipes from https://rapidapi.com/apidojo/api/yummly2.
Because of yummly2 API sometimes responses a recipe without nutrition or instructions, it is possible to receive recipe without these information. 

I used:
* Spring Boot to create application
* OkHttpClient to communicate with API
* Gson to map JSON objects to Java objects

## API Reference

#### Get random recipe

```http
  GET /api/recipes/one
```

#### Get recipes by name 

```http
  GET /api/recipes
```

| Parameter | Type     | Description                                                             |
|:----------|:---------|:------------------------------------------------------------------------|
| `name`    | `string` | **Required**. Name of recipe or ingredient in recipe                    |
| `start`   | `int`    | **Optional***. The offset of items to be ignored in response for paging |
| `limit`   | `int`    | **Optional***. Number of items returned per response                    |

limit > 0 , start >= 0 , start + limit <= 500 

Example Request
```http 
GET http://localhost:9000/api/recipes?name=chicken&limit=1&start=0
```
Example Response
```json

{
  "ingredientDtoList": [
    {
      "ingredient": "nonstick cooking spray",
      "quantity": 0.0,
      "wholeLine": "Nonstick cooking spray"
    },
    {
      "ingredient": "boneless skinless chicken breasts",
      "quantity": 2.0,
      "wholeLine": "2 lb. boneless skinless chicken breasts (pounded 3/4” thick, approx. 4 breasts)"
    },
    {
      "ingredient": "salt",
      "quantity": 2.0,
      "wholeLine": "2 tsp. salt"
    },
    {
      "ingredient": "black pepper",
      "quantity": 0.25,
      "wholeLine": "1/4 tsp. black pepper"
    },
    {
      "ingredient": "garlic powder",
      "quantity": 1.0,
      "wholeLine": "1 tsp. garlic powder"
    },
    {
      "ingredient": "mayonnaise",
      "quantity": 0.25,
      "wholeLine": "1/4 cup mayonnaise"
    },
    {
      "ingredient": "plain greek yogurt",
      "quantity": 0.25,
      "wholeLine": "1/4 cup plain Greek yogurt"
    },
    {
      "ingredient": "shredded Parmesan cheese",
      "quantity": 0.5,
      "wholeLine": "1/2 cup shredded Parmesan cheese"
    }
  ],
  "instructionDtoList": [
    {
      "instruction": "Preheat the oven to 375°F. Spray a 9x13-inch baking dish with nonstick cooking spray."
    },
    {
      "instruction": "Season the chicken breasts liberally on both sides with the salt, pepper, and garlic powder. Arrange in a single layer in the prepared baking dish."
    },
    {
      "instruction": "Stir together the mayonnaise and Greek yogurt in a small bowl. Spread the mixture evenly over the tops of the chicken breasts."
    },
    {
      "instruction": "Sprinkle the Parmesan cheese evenly over the chicken breasts."
    },
    {
      "instruction": "Bake the chicken breasts on middle rack of oven until the cheese is melted and lightly browned, and the chicken has reached an internal temperature of 160°F, 25-30 minutes."
    },
    {
      "instruction": "Check to see that chicken is done. Remove from oven or add time as needed."
    },
    {
      "instruction": "Serve the chicken breasts immediately."
    }
  ],
  "nutritionDtoList": [
    {
      "kcal": 297.0
    }
  ],
  "totalTime": "40 Min",
  "description": "These creamy, cheesy chicken breasts will, as their title says, melt in your mouth. The recipe is a Yummly original created by [Sara Mellas](https://www.yummly.com/dish/author/Sara%20Mellas).",
  "name": "Melt-In-Your-Mouth Baked Chicken Breasts",
  "numberOfServings": "6"
}
```
Example Request
```http 
GET http://localhost:9000/api/recipes/one
```
Example Response
```json
{
  "message": "query params: name is required, limit(must be greater than 0) and start(must be greater than -1) are optional but limit + start must not be greater than 500"
}
```
Example Request
```http 
GET http://localhost:9000/api/recipes?name=egg&limit=1&start=500
```
Example Response
```json
{
  "ingredientDtoList": [
    {
      "ingredient": "nonstick cooking spray",
      "quantity": 0.0,
      "wholeLine": "Nonstick cooking spray"
    },
    {
      "ingredient": "cabbage",
      "quantity": 1.0,
      "wholeLine": "1 head cabbage"
    },
    {
      "ingredient": "extra-virgin olive oil",
      "quantity": 1.0,
      "wholeLine": "1 Tbsp. olive oil"
    },
    {
      "ingredient": "garlic salt",
      "quantity": 1.0,
      "wholeLine": "1 tsp. garlic salt"
    },
    {
      "ingredient": "onion powder",
      "quantity": 1.0,
      "wholeLine": "1 tsp. onion powder"
    },
    {
      "ingredient": "black pepper",
      "quantity": 0.25,
      "wholeLine": "1/4 tsp. black pepper"
    }
  ],
  "instructionDtoList": [
    {
      "instruction": "Preheat the oven to 425°F."
    },
    {
      "instruction": "Spray a baking sheet with nonstick cooking spray. Remove outer leaves from the cabbage and discard. Slice the stem (also called the core) from the cabbage and discard. Place cut-side down on the cutting board, then cut into 1-inch slices."
    },
    {
      "instruction": "Lay the cabbage slices on the baking sheet, then drizzle with the olive oil and sprinkle with the garlic salt, onion powder, salt, and pepper. Gently turn to coat both sides of cabbage with oil and spices. Spread slices out into a single layer."
    },
    {
      "instruction": "Transfer baking sheet to oven and bake 30-35 minutes, until cabbage is tender and slightly charred. "
    },
    {
      "instruction": "Check to see that the cabbage is done. Remove from oven or add time as needed."
    },
    {
      "instruction": "Serve immediately."
    }
  ],
  "nutritionDtoList": [
    {
      "kcal": 93.05
    }
  ],
  "totalTime": "45 Min",
  "description": "Tender, slightly charred cabbage steaks are seasoned with a savory blend of garlic and onion. The recipe is a Yummly original created by [Danielle Moore](https://www.yummly.com/dish/author/Danielle-Moore).",
  "name": "Oven Roasted Cabbage Steaks",
  "numberOfServings": "4"
}
```