@smoke
  Feature: how to apply search outline in cucumber
    Scenario Outline: user could search using product name
      When user enters product "<Name>" in search box
      And user press on search button
      Then search shows relevant results of "<Name>"
      Examples:
      |Name  |
      |book  |
      |laptop|
      |nike  |


    Scenario Outline: user could search using sku
      When user search using product sku "<Sku>"
      And user click on the product in search result
      Then search shows relevant results of product "<Sku>"
      Examples:
      |Sku      |
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|
