@a = common global i32 0
@b = global i40 6
@c = common global i24 0

define i64 @main(){
call void @accept_i32(i32* @a)
call void @accept_i40(i40* @b)
br label %tmp_0
tmp_0:
%tmp_3 = load i40* @b
%tmp_4 = add i32 0, 0
%tmp_6 = sext i32 %tmp_4 to i40
%tmp_5 = icmp eq i40 %tmp_3, %tmp_6
%tmp_7 = xor i1 %tmp_5, true
br i1 %tmp_7, label %tmp_1, label %tmp_2
tmp_1:
call void @find()
br label %tmp_0
tmp_2:
call void @display_string(i8* getelementptr inbounds ([10 x i8]* @.str0, i32 0, i32 0))
%tmp_8 = load i32* @a
call void @display_i32(i32 %tmp_8)
ret i64 0
}

define void @find(){
%tmp_0 = load i40* @b
%tmp_1 = trunc i40 %tmp_0 to i24
store i24 %tmp_1, i24* @c
br label %tmp_2
tmp_2:
%tmp_5 = load i32* @a
%tmp_6 = load i40* @b
%tmp_8 = sext i32 %tmp_5 to i40
%tmp_7 = icmp slt i40 %tmp_8, %tmp_6
%tmp_9 = xor i1 %tmp_7, true
br i1 %tmp_9, label %tmp_3, label %tmp_4
tmp_3:
call void @diff()
br label %tmp_2
tmp_4:
%tmp_10 = load i32* @a
%tmp_11 = sext i32 %tmp_10 to i40
store i40 %tmp_11, i40* @b
%tmp_12 = load i24* @c
%tmp_13 = sext i24 %tmp_12 to i32
store i32 %tmp_13, i32* @a
ret void
}

define void @diff(){
%tmp_0 = load i40* @b
%tmp_1 = load i32* @a
%tmp_2 = sext i32 %tmp_1 to i40
%tmp_3 = sub i40 %tmp_2, %tmp_0
%tmp_4 = trunc i40 %tmp_3 to i32
store i32 %tmp_4, i32* @a
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
  %tmp_1 = alloca i32, align 8
  %tmp_c = alloca i32, align 4
  store i32 %it, i32* %tmp_1, align 8
  %tmp_2 = load i32* %tmp_1, align 8
  %tmp_3 = urem i32 %tmp_2, 10
  %tmp_4 = add i32 48, %tmp_3
  store i32 %tmp_4, i32* %tmp_c, align 4
  %tmp_6 = load i32* %tmp_1, align 8
  %tmp_7 = udiv i32 %tmp_6, 10
  store i32 %tmp_7, i32* %tmp_1, align 8
  %tmp_8 = load i32* %tmp_1, align 8
  %tmp_9 = icmp ugt i32 %tmp_8, 0
  br i1 %tmp_9, label %tmp_10, label %tmp_12

tmp_10:                                      ; preds = %tmp_0
  %tmp_11 = load i32* %tmp_1, align 8
  call void @display_i32(i32 %tmp_11)
  br label %tmp_12

tmp_12:                                      ; preds = %tmp_10, %tmp_0
  %tmp_13 = load i32* %tmp_c, align 4
  %tmp_14 = call i32 @putchar(i32 %tmp_13)
  ret void
}
declare i32 @putchar(i32)
define void @accept_i40(i40* %it) nounwind uwtable {
  %tmp_1 = alloca i40*, align 8
  %tmp_c = alloca i32, align 4
  store i40* %it, i40** %tmp_1, align 8
  %tmp_2 = load i40** %tmp_1, align 8
  store i40 0, i40* %tmp_2, align 8
  br label %tmp_3

tmp_3:                                       ; preds = %tmp_0, %tmp_12
  %tmp_4 = call i32 @getchar()
  store i32 %tmp_4, i32* %tmp_c, align 4
  %tmp_5 = load i32* %tmp_c, align 4
  %tmp_6 = icmp slt i32 %tmp_5, 48
  br i1 %tmp_6, label %tmp_7, label %tmp_8

tmp_7:                                       ; preds = %tmp_3
  br label %tmp_22

tmp_8:                                       ; preds = %tmp_3
  %tmp_9 = load i32* %tmp_c, align 4
  %tmp_10 = icmp sgt i32 %tmp_9, 57
  br i1 %tmp_10, label %tmp_11, label %tmp_12

tmp_11:                                      ; preds = %tmp_8
  br label %tmp_22

tmp_12:                                      ; preds = %tmp_8
  %tmp_13 = load i40** %tmp_1, align 8
  %tmp_14 = load i40* %tmp_13, align 8
  %tmp_15 = mul i40 %tmp_14, 10
  store i40 %tmp_15, i40* %tmp_13, align 8
  %tmp_16 = load i32* %tmp_c, align 4
  %tmp_17 = sub nsw i32 %tmp_16, 48
  %tmp_18 = sext i32 %tmp_17 to i40
  %tmp_19 = load i40** %tmp_1, align 8
  %tmp_20 = load i40* %tmp_19, align 8
  %tmp_21 = add i40 %tmp_20, %tmp_18
  store i40 %tmp_21, i40* %tmp_19, align 8
  br label %tmp_3

tmp_22:                                      ; preds = %tmp_11, %tmp_7
  ret void
}
define void @accept_i32(i32* %it) nounwind uwtable {
  %tmp_1 = alloca i32*, align 8
  %tmp_c = alloca i32, align 4
  store i32* %it, i32** %tmp_1, align 8
  %tmp_2 = load i32** %tmp_1, align 8
  store i32 0, i32* %tmp_2, align 8
  br label %tmp_3

tmp_3:                                       ; preds = %tmp_0, %tmp_12
  %tmp_4 = call i32 @getchar()
  store i32 %tmp_4, i32* %tmp_c, align 4
  %tmp_5 = load i32* %tmp_c, align 4
  %tmp_6 = icmp slt i32 %tmp_5, 48
  br i1 %tmp_6, label %tmp_7, label %tmp_8

tmp_7:                                       ; preds = %tmp_3
  br label %tmp_22

tmp_8:                                       ; preds = %tmp_3
  %tmp_9 = load i32* %tmp_c, align 4
  %tmp_10 = icmp sgt i32 %tmp_9, 57
  br i1 %tmp_10, label %tmp_11, label %tmp_12

tmp_11:                                      ; preds = %tmp_8
  br label %tmp_22

tmp_12:                                      ; preds = %tmp_8
  %tmp_13 = load i32** %tmp_1, align 8
  %tmp_14 = load i32* %tmp_13, align 8
  %tmp_15 = mul i32 %tmp_14, 10
  store i32 %tmp_15, i32* %tmp_13, align 8
  %tmp_16 = load i32* %tmp_c, align 4
  %tmp_17 = sub nsw i32 %tmp_16, 48
  %tmp_19 = load i32** %tmp_1, align 8
  %tmp_20 = load i32* %tmp_19, align 8
  %tmp_21 = add i32 %tmp_20, %tmp_17
  store i32 %tmp_21, i32* %tmp_19, align 8
  br label %tmp_3

tmp_22:                                      ; preds = %tmp_11, %tmp_7
  ret void
}
declare i32 @getchar()
