rgb = [0]*3
for i in range(int(input())):
    RGB = list(map(int, input().split()))
    RGB[0] += min(rgb[1],rgb[2])
    RGB[1] += min(rgb[0],rgb[2])
    RGB[2] += min(rgb[0],rgb[1])
    rgb = RGB
print(min(RGB))