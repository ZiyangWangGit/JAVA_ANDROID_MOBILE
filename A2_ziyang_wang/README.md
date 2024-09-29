# Culinary App

This Android app is designed for culinary enthusiasts and home cooks. It features a recipe library, detailed cooking instructions, customizable timers for recipes, and feedback functionality. The app's structure utilizes fragments for a dynamic and interactive user experience, allowing navigation between home, recipe library, cooking timer, and feedback sections through a `BottomNavigationView`.

## Features

1. **Home Fragment**:
   - Displays welcome content, including instructions and featured recipes or cooking tips.
   - Provides initial user interaction and navigation through the app.
  
2. **Recipe Fragment**:
   - Lists a variety of recipes (e.g., Red Curry, Beef Tacos, Parmesan Chicken).
   - Users can click on a recipe to view its details, including ingredients and cooking instructions.
   - Users can also start timers tailored to each recipe's cooking time.
  
3. **Timer Fragment**:
   - A timer for cooking each recipe, adjustable via a `SeekBar`.
   - The timer displays the recipe name, cook time, and a countdown timer.
   - Start, pause, and reset functionalities are available to control the timer.
   - Cooking times for each recipe are pre-set and passed when starting the timer.
  
4. **Feedback Fragment**:
   - Users can submit feedback on the recipes or the app.
   - A `Toast` message confirms successful submission.

## File Structure

- **MainActivity.java**: 
  - Hosts the `BottomNavigationView` and manages the app’s fragment transactions.
  - The `BottomNavigationView` allows users to switch between fragments.
  
- **Fragments**:
  - **HomeFragment.java**: Provides home screen content.
  - **RecipeFragment.java**: Lists recipes and allows users to navigate to details or set a cooking timer for each recipe.
  - **TimerFragment.java**: Displays and controls the countdown timer for each recipe. It can be updated with new recipes and times.
  - **FeedbackFragment.java**: Allows users to submit feedback via a button, triggering a confirmation `Toast`.

- **Recipe Detail Activities**:
  - Each recipe has a corresponding detail activity, displaying ingredients and cooking instructions.

## How to Use

1. **Home**:
   - Start on the home screen to view featured recipes and get a brief overview of the app's purpose.

2. **Recipes**:
   - Navigate to the Recipe tab to view the list of available dishes.
   - Click on a recipe to view its detailed ingredients and instructions.
   - Alternatively, start the corresponding timer directly from the recipe list.

3. **Cooking Timer**:
   - Use the Timer tab to set a cooking countdown for your selected recipe.
   - Adjust the timer using the `SeekBar` and start, pause, or reset as needed.

4. **Feedback**:
   - Provide feedback by navigating to the Feedback tab and clicking the Submit button.
   - A confirmation `Toast` will notify you of a successful submission.

