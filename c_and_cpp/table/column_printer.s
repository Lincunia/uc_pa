	.file	"column_printer.c"
	.text
	.section	.rodata.str1.1,"aMS",@progbits,1
.LC0:
	.string	"|"
	.text
	.p2align 4
	.globl	print_line_division
	.type	print_line_division, @function
print_line_division:
.LFB11:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movl	%edi, %ebp
	movl	$124, %edi
	pushq	%rbx
	.cfi_def_cfa_offset 24
	.cfi_offset 3, -24
	subq	$8, %rsp
	.cfi_def_cfa_offset 32
	call	putchar@PLT
	cmpl	$1, %ebp
	je	.L2
	subl	$1, %ebp
	xorl	%ebx, %ebx
	.p2align 4
	.p2align 3
.L3:
	movl	$45, %edi
	addl	$1, %ebx
	call	putchar@PLT
	cmpl	%ebx, %ebp
	jne	.L3
.L2:
	addq	$8, %rsp
	.cfi_def_cfa_offset 24
	leaq	.LC0(%rip), %rdi
	popq	%rbx
	.cfi_def_cfa_offset 16
	popq	%rbp
	.cfi_def_cfa_offset 8
	jmp	puts@PLT
	.cfi_endproc
.LFE11:
	.size	print_line_division, .-print_line_division
	.section	.rodata.str1.1
.LC1:
	.string	"| %s"
	.text
	.p2align 4
	.globl	print_inside
	.type	print_inside, @function
print_inside:
.LFB12:
	.cfi_startproc
	pushq	%r12
	.cfi_def_cfa_offset 16
	.cfi_offset 12, -16
	movq	%rdi, %r12
	pushq	%rbp
	.cfi_def_cfa_offset 24
	.cfi_offset 6, -24
	movq	%rdx, %rbp
	pushq	%rbx
	.cfi_def_cfa_offset 32
	.cfi_offset 3, -32
	call	strlen@PLT
	movq	%r12, %rsi
	leaq	.LC1(%rip), %rdi
	leaq	2(%rax), %rbx
	xorl	%eax, %eax
	call	printf@PLT
	movslq	%ebx, %rbx
	cmpq	%rbp, %rbx
	jnb	.L11
	.p2align 4
	.p2align 3
.L12:
	movl	$9, %edi
	addq	$8, %rbx
	call	putchar@PLT
	cmpq	%rbp, %rbx
	jb	.L12
.L11:
	popq	%rbx
	.cfi_def_cfa_offset 24
	leaq	.LC0(%rip), %rdi
	popq	%rbp
	.cfi_def_cfa_offset 16
	popq	%r12
	.cfi_def_cfa_offset 8
	jmp	puts@PLT
	.cfi_endproc
.LFE12:
	.size	print_inside, .-print_inside
	.section	.rodata.str1.1
.LC2:
	.string	"CONTENT"
	.section	.text.startup,"ax",@progbits
	.p2align 4
	.globl	main
	.type	main, @function
main:
.LFB13:
	.cfi_startproc
	pushq	%r15
	.cfi_def_cfa_offset 16
	.cfi_offset 15, -16
	pushq	%r14
	.cfi_def_cfa_offset 24
	.cfi_offset 14, -24
	movq	%rsi, %r14
	pushq	%r13
	.cfi_def_cfa_offset 32
	.cfi_offset 13, -32
	movl	%edi, %r13d
	pushq	%r12
	.cfi_def_cfa_offset 40
	.cfi_offset 12, -40
	pushq	%rbp
	.cfi_def_cfa_offset 48
	.cfi_offset 6, -48
	pushq	%rbx
	.cfi_def_cfa_offset 56
	.cfi_offset 3, -56
	subq	$40, %rsp
	.cfi_def_cfa_offset 96
	cmpl	$1, %edi
	jle	.L16
	leaq	8(%rsi), %rax
	leaq	16(%rsi), %r15
	movl	$7, %ebp
	movq	%rax, 24(%rsp)
	movq	%rax, %r12
	leal	-2(%rdi), %eax
	movl	%eax, 20(%rsp)
	leaq	(%r15,%rax,8), %rbx
	.p2align 4
	.p2align 3
.L17:
	movq	(%r12), %rdi
	call	strlen@PLT
	cmpq	%rax, %rbp
	cmovb	%rax, %rbp
	addq	$8, %r12
	cmpq	%r12, %rbx
	jne	.L17
	leaq	2(%rbp), %r12
	andq	$-8, %r12
	leaq	8(%r12), %rbx
	movl	%ebx, %edi
	movl	%ebx, 16(%rsp)
	call	print_line_division
	leaq	.LC1(%rip), %rax
	leaq	.LC2(%rip), %rsi
	movq	%rax, 8(%rsp)
	movq	%rax, %rdi
	xorl	%eax, %eax
	call	printf@PLT
	cmpq	$9, %rbx
	jbe	.L35
.L24:
	subq	$2, %r12
	xorl	%r15d, %r15d
	shrq	$3, %r12
	addq	$1, %r12
	.p2align 4
	.p2align 3
.L19:
	movl	$9, %edi
	addq	$1, %r15
	call	putchar@PLT
	cmpq	%r15, %r12
	jne	.L19
	leaq	.LC0(%rip), %r12
	movq	%r12, %rdi
	call	puts@PLT
	movl	16(%rsp), %edi
	call	print_line_division
	cmpl	$1, %r13d
	jle	.L20
	leaq	8(%r14), %rax
	leaq	16(%r14), %r15
	movq	%rax, 24(%rsp)
	leal	-2(%r13), %eax
	movl	%eax, 20(%rsp)
.L25:
	movl	20(%rsp), %eax
	movq	24(%rsp), %r13
	leaq	(%r15,%rax,8), %r15
	.p2align 4
	.p2align 3
.L23:
	movq	0(%r13), %rbp
	movq	%rbp, %rdi
	call	strlen@PLT
	movq	8(%rsp), %rdi
	movq	%rbp, %rsi
	leaq	2(%rax), %r14
	xorl	%eax, %eax
	call	printf@PLT
	movslq	%r14d, %r14
	cmpq	%rbx, %r14
	jnb	.L21
	.p2align 4
	.p2align 3
.L22:
	movl	$9, %edi
	addq	$8, %r14
	call	putchar@PLT
	cmpq	%rbx, %r14
	jb	.L22
.L21:
	movq	%r12, %rdi
	addq	$8, %r13
	call	puts@PLT
	cmpq	%r13, %r15
	jne	.L23
.L20:
	movl	16(%rsp), %edi
	call	print_line_division
	addq	$40, %rsp
	.cfi_remember_state
	.cfi_def_cfa_offset 56
	xorl	%eax, %eax
	popq	%rbx
	.cfi_def_cfa_offset 48
	popq	%rbp
	.cfi_def_cfa_offset 40
	popq	%r12
	.cfi_def_cfa_offset 32
	popq	%r13
	.cfi_def_cfa_offset 24
	popq	%r14
	.cfi_def_cfa_offset 16
	popq	%r15
	.cfi_def_cfa_offset 8
	ret
.L16:
	.cfi_restore_state
	movl	$16, %edi
	movl	$16, %ebx
	movl	$8, %r12d
	call	print_line_division
	leaq	.LC1(%rip), %rax
	leaq	.LC2(%rip), %rsi
	movq	%rax, 8(%rsp)
	movq	%rax, %rdi
	xorl	%eax, %eax
	call	printf@PLT
	movl	$16, 16(%rsp)
	jmp	.L24
.L35:
	leaq	.LC0(%rip), %r12
	movl	$8, %ebx
	movq	%r12, %rdi
	call	puts@PLT
	movl	$8, %edi
	call	print_line_division
	movl	$8, 16(%rsp)
	jmp	.L25
	.cfi_endproc
.LFE13:
	.size	main, .-main
	.ident	"GCC: (GNU) 15.2.1 20260209"
	.section	.note.GNU-stack,"",@progbits
