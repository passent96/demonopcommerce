@smoke
  Feature: adding product to wishlist
    Scenario: user add product to wishlist
      Given user finds 4 products in the middle of home page
      When user clicks on wishlist button on this product "HTC One M8 Android L 5.0 Lollipop"
      Then success message  "The product has been added to your wishlist" displayed with green color


      Scenario: user gets quantity value in wishlist
        When user clicks on wishlist button on this product "HTC One M8 Android L 5.0 Lollipop"
        And user wait until success message disappear and click on wishlist tab
        Then user gets Qty value and verify it's bigger than "0"
