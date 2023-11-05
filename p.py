T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    ans = 0
    k = 1
    check = 0
    x = (1<<10) - 1
    num = k * N
    while True:
        c = num % 10
        num //= 10
        check = check | (1<<c)
        if check == x:
            break
        if num == 0:
            k += 1
            num = k * N
    ans = k * N 
    print(f'#{tc} {ans}')
    