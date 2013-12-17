@a = common global i32 0
@b = global i40 6
@c = common global i24 0

define i64 @main(){
call void @accept_i32(i32* @a)
call void @accept_i40(i40* @b)
br label %register0
register0:
%register3 = load i40* @b
%register4 = add i32 0, 0
%register6 = sext i32 %register4 to i40
%register5 = icmp eq i40 %register3, %register6
%register7 = xor i1 %register5, true
br i1 %register7, label %register1, label %register2
register1:
call void @find()
br label %register0
register2:
call void @display_string(i8* getelementptr inbounds ([10 x i8]* @.str0, i32 0, i32 0))
%register8 = load i32* @a
call void @display_i32(i32 %register8)
ret i64 0
}

define void @find(){
%register0 = load i40* @b
%register1 = trunc i40 %register0 to i24
store i24 %register1, i24* @c
br label %register2
register2:
%register5 = load i32* @a
%register6 = load i40* @b
%register8 = sext i32 %register5 to i40
%register7 = icmp slt i40 %register8, %register6
%register9 = xor i1 %register7, true
br i1 %register9, label %register3, label %register4
register3:
call void @diff()
br label %register2
register4:
%register10 = load i32* @a
%register11 = sext i32 %register10 to i40
store i40 %register11, i40* @b
%register12 = load i24* @c
%register13 = sext i24 %register12 to i32
store i32 %register13, i32* @a
ret void
}

define void @diff(){
%register0 = load i40* @b
%register1 = load i32* @a
%register2 = sext i32 %register1 to i40
%register3 = sub i40 %register2, %register0
%register4 = trunc i40 %register3 to i32
store i32 %register4, i32* @a
ret void
}

@.str0 = private unnamed_addr constant [10 x i8] c"\27\76\61\6C\65\75\72\3A\27\00"
define void @display_string(i8* %string) nounwind uwtable {
  %1 = alloca i8*, align 8
  store i8* %string, i8** %1, align 8
  br label %2

; <label>:2                                       ; preds = %7, %0
  %3 = load i8** %1, align 8
  %4 = load i8* %3, align 1
  %5 = sext i8 %4 to i32
  %6 = icmp ne i32 %5, 0
  br i1 %6, label %7, label %14

; <label>:7                                       ; preds = %2
  %8 = load i8** %1, align 8
  %9 = load i8* %8, align 1
  %10 = sext i8 %9 to i32
  %11 = call i32 @putchar(i32 %10)
  %12 = load i8** %1, align 8
  %13 = getelementptr inbounds i8* %12, i32 1
  store i8* %13, i8** %1, align 8
  br label %2

; <label>:14                                      ; preds = %2
  ret void
}
define void @display_i32(i32 %it) nounwind uwtable {
  %1 = alloca i32, align 8
  %c = alloca i32, align 4
  store i32 %it, i32* %1, align 8
  %2 = load i32* %1, align 8
  %3 = urem i32 %2, 10
  %4 = add i32 48, %3
  %5 = trunc i32 %4 to i32
  store i32 %5, i32* %c, align 4
  %6 = load i32* %1, align 8
  %7 = udiv i32 %6, 10
  store i32 %7, i32* %1, align 8
  %8 = load i32* %1, align 8
  %9 = icmp ugt i32 %8, 0
  br i1 %9, label %10, label %12

; <label>:10                                      ; preds = %0
  %11 = load i32* %1, align 8
  call void @display_i32(i32 %11)
  br label %12

; <label>:12                                      ; preds = %10, %0
  %13 = load i32* %c, align 4
  %14 = call i32 @putchar(i32 %13)
  ret void
}
declare i32 @putchar()
define void @accept_i40(i40* %it) nounwind uwtable {
  %1 = alloca i40*, align 8
  %c = alloca i32, align 4
  store i40* %it, i40** %1, align 8
  %2 = load i40** %1, align 8
  store i40 0, i40* %2, align 8
  br label %3

; <label>:3                                       ; preds = %0, %12
  %4 = call i32 @getchar()
  store i32 %4, i32* %c, align 4
  %5 = load i32* %c, align 4
  %6 = icmp slt i32 %5, 48
  br i1 %6, label %7, label %8

; <label>:7                                       ; preds = %3
  br label %22

; <label>:8                                       ; preds = %3
  %9 = load i32* %c, align 4
  %10 = icmp sgt i32 %9, 57
  br i1 %10, label %11, label %12

; <label>:11                                      ; preds = %8
  br label %22

; <label>:12                                      ; preds = %8
  %13 = load i40** %1, align 8
  %14 = load i40* %13, align 8
  %15 = mul i40 %14, 10
  store i40 %15, i40* %13, align 8
  %16 = load i32* %c, align 4
  %17 = sub nsw i32 %16, 48
  %18 = sext i32 %17 to i40
  %19 = load i40** %1, align 8
  %20 = load i40* %19, align 8
  %21 = add i40 %20, %18
  store i40 %21, i40* %19, align 8
  br label %3

; <label>:22                                      ; preds = %11, %7
  ret void
}
define void @accept_i32(i32* %it) nounwind uwtable {
  %1 = alloca i32*, align 8
  %c = alloca i32, align 4
  store i32* %it, i32** %1, align 8
  %2 = load i32** %1, align 8
  store i32 0, i32* %2, align 8
  br label %3

; <label>:3                                       ; preds = %0, %12
  %4 = call i32 @getchar()
  store i32 %4, i32* %c, align 4
  %5 = load i32* %c, align 4
  %6 = icmp slt i32 %5, 48
  br i1 %6, label %7, label %8

; <label>:7                                       ; preds = %3
  br label %22

; <label>:8                                       ; preds = %3
  %9 = load i32* %c, align 4
  %10 = icmp sgt i32 %9, 57
  br i1 %10, label %11, label %12

; <label>:11                                      ; preds = %8
  br label %22

; <label>:12                                      ; preds = %8
  %13 = load i32** %1, align 8
  %14 = load i32* %13, align 8
  %15 = mul i32 %14, 10
  store i32 %15, i32* %13, align 8
  %16 = load i32* %c, align 4
  %17 = sub nsw i32 %16, 48
  %18 = sext i32 %17 to i32
  %19 = load i32** %1, align 8
  %20 = load i32* %19, align 8
  %21 = add i32 %20, %18
  store i32 %21, i32* %19, align 8
  br label %3

; <label>:22                                      ; preds = %11, %7
  ret void
}
declare i32 @getchar()
