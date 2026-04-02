	.file	"pr_2.c"
	.text
	.section	.rodata.str1.1,"aMS",@progbits,1
.LC0:
	.string	"clear"
	.text
	.p2align 4
	.globl	clear_screen
	.type	clear_screen, @function
clear_screen:
.LFB11:
	.cfi_startproc
	leaq	.LC0(%rip), %rdi
	jmp	system@PLT
	.cfi_endproc
.LFE11:
	.size	clear_screen, .-clear_screen
	.section	.text.startup,"ax",@progbits
	.p2align 4
	.globl	main
	.type	main, @function
main:
.LFB12:
	.cfi_startproc
	subq	$8, %rsp
	.cfi_def_cfa_offset 16
	leaq	.LC0(%rip), %rdi
	call	system@PLT
	xorl	%eax, %eax
	addq	$8, %rsp
	.cfi_def_cfa_offset 8
	ret
	.cfi_endproc
.LFE12:
	.size	main, .-main
	.ident	"GCC: (GNU) 15.2.1 20260209"
	.section	.note.GNU-stack,"",@progbits
