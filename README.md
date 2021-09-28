final_project

Final project tasks

All following test cases should be implemented with BDD or using Page Object pattern
Logging and Reporting should be implemented
Should be abillity to run tests in 2 threads
Should be ability to pass browser, browser resolution, and thread count as parameters
All logical blocks on pages should be implemented as separate classes
If some test cases will fail - create bug report for them
Test case #1 (Subscribe with invalid email)

Go to the https://demo.prestashop.com/
On the buttom of the page check that text near the email field equals 'Get our latest news and special sales'
On the buttom of the page check that text under email field contains 'You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.'
Check that all characters on 'SUBSCRIBE' button in upper case
Test case #2 (Check languages)

Go to the https://demo.prestashop.com/
Check that 44 langueges exists in 'Language' dropdown in the top menu
Check that 'Українська' language exist in dropdown
Test case #3 (Registration with valid data)

Go to the https://demo.prestashop.com/
Click on 'Sign in' button at the right corner of the page
Click on 'No account? Create one here' link
Fill the form with valid data
Click on 'Save' button
Check your name appear near cart button
Test case #4 (Registration with invalid data)

Go to the https://demo.prestashop.com/
Click on 'Sign in' button at the right corner of the page
Click on 'No account? Create one here' link
Fill 'First name' field with 'James8'
Fill the rest fields valid data
Check that 'First name' higlighted in red
Check that pop-up with text 'Invalid name' appear under field
Test case #5 (Check categories)

Go to the https://demo.prestashop.com/
Hover mouse over 'CLOTHES'
Check that 'MEN' and 'WOMEN' sub menu items appears
Hover mouse over 'ACCESSORIES'
Check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears
Hover mouse over 'ART'
Check that no any sub category appears
Test case #6 (Check popular products)

Go to the https://demo.prestashop.com/
Check that 8 products exist in 'POPULAR PRODUCTS' section
Check that every product has name
Check that every product has price
Check that all prices bigger than 0.00
Test case #7 (Price drop check)

Go to the https://demo.prestashop.com/
At the bottom of the page click on 'Prices drop' link
Check that every product has old and new price
Check that promo price for every product calculates correct
Test case #8 (Sorting check)

Go to the https://demo.prestashop.com/
Click on the 'All products >' under the 'POPULAR PRODUCTS' section
Sort products as 'Name, A to Z'
Check that sorting is correct
Sort products as 'Name, Z to A'
Check that sorting is correct
Sort products as 'Price, low to high'
Check that sorting is correct
Sort products as 'Price, high to low'
Check that sorting is correct
Test case #9 (Adding to cart)

Go to the https://demo.prestashop.com/
In the search field enter 'Bear' and press 'Enter'
On the 'SEARCH RESULTS' page click on 'Brown Bear Notebook'
Change 'Paper type' to 'Doted'
Change 'Quantity' to '5'
Click 'ADD TO CART' button
Check that new window with title 'Product successfully added to your shopping cart' appears
Check that correct 'Paper Type' and 'Quantity' is shown on the left side of the window
Check that 'Total' calculated correct
Test case #10 (Checkout end-to-end)

Go to the https://demo.prestashop.com/
In the search field enter 'Mug' and press 'Enter'
On the 'SEARCH RESULTS' page click on 'Customizable Mug'
Enter 'Best mug ever' in 'Product customization' field
Click 'SAVE CUSTOMIZATION'
Change 'Quantity' to '1' if not '1' already
Click 'ADD TO CART' button
On the next window click 'CONTINUE SHOPPING'
In the search field enter 'T-Shirt' and press 'Enter'
On the 'SEARCH RESULTS' page click on 'Hummingbird Printed T-Shirt'
Select 'Black' color
Click 'ADD TO CART' button
On the next window click 'PROCEED TO CHECKOUT'
On the 'SHOPPING CART' page check that 'Total' calculated correct
Click 'PROCEED TO CHECKOUT'
Fill 'PERSONAL INFORMATION' form with valid data (without password)
Click 'CONTINUE'
Fill the 'ADDRESSES' form with valid data
Click 'CONTINUE'
On the 'SHIPPING METHOD' section select 'My carrier'
Click 'CONTINUE'
On the 'PAYMENT' section select 'Pay by Check'
Check that Amount equal Subtotal+Shipping
Click on 'I agree..' checkbox
Click on 'Order with an obligation to pay'
Check that 'YOUR ORDER IS CONFIRMED' appered on the next page
Check that 'TOTAL' calculated correct