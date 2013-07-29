Meta:

Narrative:
As a user
I want to perform an add calculation
So that I can get the twice of numbers

Scenario: twice the number
Given the kvs:
|key|value|
|a  |1    |
|b  |2    |

When twice the value:

Then value is twiced:
|key|value|
|a  |2    |
|b  |4    |
