# Codecool shop (sprint 1)

## Story

Everyone loves to buy and sell stuff, but we need a shop for that! In this
project, the goal is to build one of the [most common type of websites on the
web](https://www.expertmarket.co.uk/web-design/different-types-of-websites): an
online eCommerce web-application, where users can browse products, add them into
a shopping cart, then check out and make payments.

## What are you going to learn?

- how to create dynamic web pages in `Java` with `Spring`,
- how to use the `DAO` design pattern in `Java`,
- how to use the `Thymeleaf` templating engine.
- how to handle fractional monetary unit appropriately with BigDecimal


## Tasks

1. As a Developer, I want to have a version-controlled project, where a webserver serves requests. This allows me to start developing in a sandboxed environment.
    - When starting up the Java web-application server, and opening `http://localhost:8080` in my browser, the server returns an index page.

2. As a User, I want to have an index page, where I can see the list of Products in a default Product Category.
    - There are Products and a default Product Category in the application. Opening the root URL (`/`) displays a list of Products with details such as product title, description, image, price.

3. As a User, I want to have an index page, where I can filter Products by Product Categories.
    - There are Products and Product Categories listed on the index page. Clicking on the title of a Category displays Products only in the selected Category.

4. As a User, I want to have an index page where I can filter Products by Suppliers.
    - There are Products and Suppliers listed on the index page. Clicking on the name of a Supplier displays the Products only for the selected Supplier.

5. As a User, I want to have a Shopping Cart so that I can add products which I want to buy.
    - In the Product list, the Products have an "Add to cart" button. Clicking the "Add to cart" button creates a new Order for storing cart data and a new LineItem with the quantity (default: 1) and price of the Product. This data is stored on the server.
    - In the Product list, the Products have an "Add to cart" button. Clicking the "Add to cart" button displays the number of cart items in the Page header

6. As a User, I want to review the contents of my Shopping Cart before checking out.
    - When the Shopping Cart has items in it, clicking "Shopping cart" in the Page header displays the items (LineItems) with their data, such as name of the Product, quantity, unit price / subtotal price.
    - When the Shopping Cart has items in it, clicking "Shopping cart" in the Page header displays the total price of all the items in the cart.

7. As a User, I want to edit the quantity of items, or remove items from my Shopping Cart.
    - On the Shopping Cart review page, the LineItems are displayed in a form, and the quantities are displayed in input fields. Changing the quantity of an item stores the new quantity of the LineItem.
    - On the Shopping Cart review page, LineItems are displayed in a form, and the quantities are displayed in input fields. Changing the quantity of an item to 0 removes the LineItem from the cart.

8. As a User, I want to checkout the items from the Shopping Cart and order the Products.
    - On the Shopping Cart review page, clicking the "Checkout" button displays a form asking for user data, such as Name, Email, Phone number, Billing Address (Country, City, Zipcode, Address), and Shipping Address (Country, City, Zipcode, Address)
    - On the Shopping Cart review page, clicking the "Go to Payment" button validates the data on the checkout form.
    - After successful validatiion, the data on the checkout form is stored in the Order.
    - If the data on the checkout form is validated and stored successfully, the page redirects to the Payment page.

9. As a User, I want to pay for my Products online.
    - After checking out the items from the Shopping cart, the total price is displayed.
    - After checking out the items from the Shopping, a payment methods can be chosen. Available methods are credit card and PayPal.
    - After checking out the items from the Shopping cart and choosing the payment method, a form is displayed, asking for the credentials for the payment provider, such as card number, card holder, expiry date, and CVV code for credit cards, or username and password for PayPal.

10. As a User, I want to see the result of my payment and get a confirmation about my Order.
    - If there is an error while making a payment, the details of the error are displayed.
    - If the transaction is successful, the Confirmation page is displayed, with the details of the Order.
    - If the transaction is successful the Order is saved in a `JSON` file.
    - If the transaction is successful, an email is sent to the User about the Order.

11. As an Admin, I want to have a log file of the checkout processes (per Order), to see the steps of every Order and investigate issues.
    - If a checkout process is started, all the steps and details are saved into a JSON file. The filename is the Order ID and the Date.

## General requirements

- Advanced OOP concepts, such as inheritance, are used in the project. There is at least one abstract class and one interface implemented.
- The project maintains the three-layer structure of controllers handling HTTP, service objects handling business logic, and DAOs handling data access.
- The page does not show a server error anytime during the review.
- All code is pushed to GitHub repository in atomic commits. The implemented feature-related commits are managed on separated feature branches and merged in a pull request to the `master` branch.

## Hints

- Do not use a database. Use in-memory storage or file storage, but through the DAO (Data Access Object) pattern.
- Use fake payment implementations. It is not required to integrate real payment services.

## Background materials

- <i class="far fa-exclamation"></i> [Introducing Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- <i class="far fa-exclamation"></i> [Java Dao pattern](https://www.baeldung.com/java-dao-pattern)
- <i class="far fa-exclamation"></i> [Thymeleaf standard dialect](https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html)
- <i class="far fa-book-open"></i> [Thymeleaf introductions](https://www.thymeleaf.org/documentation.html#introductions)

