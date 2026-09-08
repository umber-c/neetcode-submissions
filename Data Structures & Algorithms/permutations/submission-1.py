class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        return [list(t) for t in product(nums, repeat=n) if len(set(t)) == n]