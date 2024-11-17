Q.This problem requires the creation of an abstract class with specific methods, and a subclass that implements these methods. The goal is to design a program in Python that simulates a "robbery" scenario in different types of houses while following certain constraints

from abc import ABC, abstractmethod

# Define the abstract class
class Robber(ABC):

    # Function to print "MScAI&ML"
    def RobbingClass(self):
        print("MScAI&ML")

    # Default method to print "I love MachineLearning"
    def MachineLearning(self):
        print("I love MachineLearning.")

    # Abstract methods that need to be implemented in child classes
    @abstractmethod
    def RowHouses(self, money):
        pass

    @abstractmethod
    def RoundHouses(self, money):
        pass

    @abstractmethod
    def SquareHouse(self, money):
        pass

    @abstractmethod
    def MuliHouseBuilding(self, *types_of_houses):
        pass
    
    
# Concrete class that inherits from Robber and implements the abstract methods
class JAVAProfessionalRobber(Robber):

    # Implement RowHouses method
    def RowHouses(self, money):
        if not money:
            return 0
        n = len(money)
        if n == 1:
            return money[0]
        dp = [0] * n
        dp[0] = money[0]
        dp[1] = max(money[0], money[1])
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + money[i])
        return dp[-1]
    
    # Implement RoundHouses method
    def RoundHouses(self, money):
        if not money:
            return 0
        n = len(money)
        if n == 1:
            return money[0]
        def rob_range(nums):
            dp = [0] * len(nums)
            dp[0] = nums[0]
            dp[1] = max(nums[0], nums[1])
            for i in range(2, len(nums)):
                dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            return dp[-1]
        # Rob two ranges: excluding the first house or the last house
        return max(rob_range(money[1:]), rob_range(money[:-1]))

    # Implement SquareHouse method
    def SquareHouse(self, money):
        if not money:
            return 0
        n = len(money)
        if n == 1:
            return money[0]
        dp = [0] * n
        dp[0] = money[0]
        for i in range(1, n):
            dp[i] = max(dp[i-1], (dp[i-2] if i >= 2 else 0) + money[i])
        return dp[-1]

    # Implement MuliHouseBuilding method
    def MuliHouseBuilding(self, *types_of_houses):
        total_money = []
        for house in types_of_houses:
            total_money.extend(house)  # Combine all the types of houses into one list
        return self.SquareHouse(total_money)


# Testing the JAVAProfessionalRobber class
robber = JAVAProfessionalRobber()

# Test Case 1: RowHouses([1, 2, 3, 0])
result = robber.RowHouses([1, 2, 3, 0])
print(f"Max money from RowHouses: {result}") 

# Test Case 2: RoundHouses([1, 2, 3, 4])
result = robber.RoundHouses([1, 2, 3, 4])
print(f"Max money from RoundHouses: {result}")  

# Test Case 3: SquareHouse([5, 10, 2, 7])
result = robber.SquareHouse([5, 10, 2, 7])
print(f"Max money from SquareHouse: {result}")  

# Test Case 4: MultiHouseBuilding([5, 3, 8, 2], [10, 12, 7, 6], [4, 9, 11, 5], [8, 6, 3, 7])
result = robber.MuliHouseBuilding([5, 3, 8, 2], [10, 12, 7, 6], [4, 9, 11, 5], [8, 6, 3, 7])
print(f"Max money from MultiHouseBuilding: {result}") 

# Call the methods from the abstract class
robber.RobbingClass()       
robber.MachineLearning() 
